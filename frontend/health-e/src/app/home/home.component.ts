import { AfterViewInit, Component, Inject, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormControl, Form } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { UserService } from '../services/user.service';

export interface RequestData {
  requestId: string;
  patientId: string;
  doctorId: string;
  reason: string;
  date: string;
  status: string;
}


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(public dialog: MatDialog, private userService: UserService, private _snackbar: MatSnackBar) { }

  displayedColumns: string[] = ['requestId', 'doctorId', 'reason', 'date', 'status', 'action'];
  dataSource!: MatTableDataSource<RequestData>;
  patientId = "";
  ngOnInit() {
    this.patientId = sessionStorage.getItem("userId") || "";
    this.fetchPatientRequests(this.patientId);
  }

  fetchPatientRequests(patientId: string) {
    this.userService.fetchPatientRequests(this.patientId).subscribe((response) => {
      console.log(response);
      this.dataSource = response;
    })
  }
  openDialog() {
    this.dialog.open(PatientInfoDialog, {
      height: '600px',
      width: '600px',
    });
  }

  statusUpdate(status: string, id: string) {
    const request = {
      requestId: id,
      status: status
    }
    this.userService.updateRequestStatus(request).subscribe((response) => {
      this._snackbar.open("Successfully updated request", "Close", {
        duration: 1500,

      });
    })
  }

  viewPatientData() {
    this.userService.fetchPatient(this.patientId).subscribe((response) => {
      this.dialog.open(ViewPatientInfoDetails, {
        height: '600px',
        width: '600px',
        data: response
      });
    })
  }
}

@Component({
  // selector: 'app-home',
  templateUrl: './viewPatientInfo-dialog.html',
  styleUrls: ['./home.component.css']
})
export class ViewPatientInfoDetails implements OnInit {
  form: FormGroup = new FormGroup({
    patientName: new FormControl(''),
    dob: new FormControl(''),
    bloodgroup: new FormControl(''),
    allergies: new FormControl(''),
    diseases: new FormControl(''),
    injuryHistory: new FormControl(''),
    medication: new FormControl(''),
    height: new FormControl(''),
    weight: new FormControl(''),
    nominee1Name: new FormControl(''),
    nominee1Contact: new FormControl(''),
    nominee2Name: new FormControl(''),
    nominee2Contact: new FormControl('')
  });
  constructor(public dialogRef: MatDialogRef<ViewPatientInfoDetails>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private userService: UserService,
    private _snackbar: MatSnackBar) { }

  ngOnInit(): void {
    this.form.get('patientName')!.setValue(this.data.patientName);
    this.form.get('dob')!.setValue(this.data.dob);
    this.form.get('height')!.setValue(this.data.height);
    this.form.get('weight')!.setValue(this.data.weight);
    this.form.get('bloodgroup')!.setValue(this.data.bloodGroup);
    this.form.get('allergies')!.setValue(this.data.allergies);
    this.form.get('diseases')!.setValue(this.data.diseases);
    this.form.get('injuryHistory')!.setValue(this.data.injuryHistory);
    this.form.get('medication')!.setValue(this.data.medication);
    this.form.get('nominee1Name')!.setValue(this.data.nominee1Name);
    this.form.get('nominee1Contact')!.setValue(this.data.nominee1Contact);
    this.form.get('nominee2Name')!.setValue(this.data.nominee2Name);
    this.form.get('nominee2Contact')!.setValue(this.data.nominee2Contact);

    // this.form.get('patientName')!.disable();
    // this.form.get('dob')!.disable();
    // this.form.get('height')!.disable();
    // this.form.get('weight')!.disable();
    // this.form.get('bloodgroup')!.disable();
    // this.form.get('allergies')!.disable();
    // this.form.get('diseases')!.disable();
    // this.form.get('injuryHistory')!.disable();
    // this.form.get('medication')!.disable();
    // this.form.get('nominee1Name')!.disable();
    // this.form.get('nominee1Contact')!.disable();
    // this.form.get('nominee2Name')!.disable();
    // this.form.get('nominee2Contact')!.disable();
  }

  editInfo() {
    const user = {
      patientName: this.form.get('firstName')!.value + " " + this.form.get('lastName')!.value,
      patientId: sessionStorage.getItem("userId"),
      dob: this.form.get('dob')!.value,
      height: this.form.get('height')!.value,
      weight: this.form.get('weight')!.value,
      bloodGroup: this.form.get('bloodgroup')!.value,
      allergies: this.form.get('allergies')!.value,
      disease: this.form.get('diseases')!.value,
      injuryHistory: this.form.get('injuryHistory')!.value,
      medication: this.form.get('medication')!.value,
      nominee1Name: this.form.get('nominee1Name')!.value,
      nominee1Contact: this.form.get('nominee1Contact')!.value,
      nominee2Name: this.form.get('nominee2Name')!.value,
      nominee2Contact: this.form.get('nominee2Contact')!.value
    }
    this.userService.editPatientData(user).subscribe((response) => {
      this._snackbar.open(response, "Close", {
        duration: 1500,

      });
      this.dialogRef.close();
    })
  }

  close() {
    this.dialogRef.close();
  }
}

@Component({
  selector: 'app-home',
  templateUrl: './patientInfo-dialog.component.html',
  styleUrls: ['./home.component.css']
})
export class PatientInfoDialog implements OnInit {

  constructor(public dialogRef: MatDialogRef<PatientInfoDialog>,
    private userService: UserService, private _snackbar: MatSnackBar) { }

  ngOnInit(): void {
  }
  form: FormGroup = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    dob: new FormControl(''),
    bloodgroup: new FormControl(''),
    allergies: new FormControl(''),
    diseases: new FormControl(''),
    injuryHistory: new FormControl(''),
    medication: new FormControl(''),
    height: new FormControl(''),
    weight: new FormControl(''),
    nominee1Name: new FormControl(''),
    nominee1Contact: new FormControl(''),
    nominee2Name: new FormControl(''),
    nominee2Contact: new FormControl('')
  });

  submit() {
    const user = {
      patientName: this.form.get('firstName')!.value + " " + this.form.get('lastName')!.value,
      patientId: sessionStorage.getItem("userId"),
      dob: this.form.get('dob')!.value,
      height: this.form.get('height')!.value,
      weight: this.form.get('weight')!.value,
      bloodGroup: this.form.get('bloodgroup')!.value,
      allergies: this.form.get('allergies')!.value,
      disease: this.form.get('diseases')!.value,
      injuryHistory: this.form.get('injuryHistory')!.value,
      medication: this.form.get('medication')!.value,
      nominee1Name: this.form.get('nominee1Name')!.value,
      nominee1Contact: this.form.get('nominee1Contact')!.value,
      nominee2Name: this.form.get('nominee2Name')!.value,
      nominee2Contact: this.form.get('nominee2Contact')!.value
    }
    this.userService.submitPatientData(user).subscribe((response) => {
      this._snackbar.open("Successfully submitted info", "Close", {
        duration: 1500,

      });
      this.dialogRef.close();
    })
  }

  close() {
    this.dialogRef.close();
  }

}
