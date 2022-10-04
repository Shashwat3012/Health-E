import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
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
export interface PatientInfo {
  patientName: string;
  patientId: string;
  dob: string;
  height: string;
  weight: string;
  allergies: string;
  medication: string;
  disease: string;
  bloodGroup: string;
  injuryHistory: string;
}
@Component({
  selector: 'app-doctor-dashboard',
  templateUrl: './doctor-dashboard.component.html',
  styleUrls: ['./doctor-dashboard.component.css']
})
export class DoctorDashboardComponent implements OnInit {
  patientInfo: any;
  patientName = "";
  patientId = "";
  dob = "";
  height = "";
  weight = "";
  bloodGroup = "";
  allergies = "";
  medication = "";
  doctorId = sessionStorage.getItem("userId") || "";
  displayedColumns: string[] = ['requestId', 'patientId', 'reason', 'date', 'status', 'action'];
  expandedElement!: PatientInfo | null;
  dataSource!: MatTableDataSource<RequestData>;

  constructor(public dialog: MatDialog, private userService: UserService) { }

  form: FormGroup = new FormGroup({
    patientId: new FormControl(''),
  });

  ngOnInit(): void {
    this.fetchPatientRequests(this.doctorId);
  }
  fetchPatientRequests(doctorId: string) {
    this.userService.fetchRequestsByDoctor(this.doctorId).subscribe((response) => {
      this.dataSource = response;
    })
  }
  fetchPatient() {
    const patientId = this.form.get('patientId')!.value;
    this.userService.fetchPatient(patientId).subscribe((response) => {
      this.dialog.open(MaskedDetails, {
        height: '600px',
        width: '600px',
        data: response
      });
    })
  }
  viewPatientData(patientId: string, status: string) {
    this.userService.fetchPatient(patientId).subscribe((response) => {
      if (status == 'Approved') {
        this.dialog.open(PatientInfoDetails, {
          height: '600px',
          width: '600px',
          data: response
        });
      } else {
        this.dialog.open(MaskedDetails, {
          height: '600px',
          width: '600px',
          data: response
        });
      }

    })
  }
  openDialog() {
    this.dialog.open(DoctorRequestDialog, {
      height: '600px',
      width: '600px',
    });
  }

}

@Component({
  // selector: 'app-home',
  templateUrl: './doctor-request-dialog.component.html',
  styleUrls: ['./doctor-dashboard.component.css']
})
export class DoctorRequestDialog implements OnInit {

  constructor(public dialogRef: MatDialogRef<DoctorRequestDialog>,
    private userService: UserService, private _snackbar: MatSnackBar) { }

  ngOnInit(): void {
  }
  form: FormGroup = new FormGroup({
    patientid: new FormControl(''),
    doctorid: new FormControl(''),
    reason: new FormControl(''),
    date: new FormControl('')
  });

  submit() {
    const request = {
      patientId: this.form.get('patientid')!.value,
      doctorId: this.form.get('doctorid')!.value,
      reason: this.form.get('reason')!.value,
      date: this.form.get('date')!.value,
      status: "Pending"
    }
    this.userService.requestData(request).subscribe((response) => {
      this._snackbar.open("Successfully Requested Data from Patient", "Close", {
        duration: 1500,

      });
    })
  }

  close() {
    this.dialogRef.close();
  }
}

@Component({
  // selector: 'app-home',
  templateUrl: './patientInfo-dialog.component.html',
  styleUrls: ['./../home/home.component.css']
})
export class PatientInfoDetails implements OnInit {
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
  });
  constructor(public dialogRef: MatDialogRef<PatientInfoDetails>, @Inject(MAT_DIALOG_DATA) public data: any,) { }
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

    this.form.get('patientName')!.disable();
    this.form.get('dob')!.disable();
    this.form.get('height')!.disable();
    this.form.get('weight')!.disable();
    this.form.get('bloodgroup')!.disable();
    this.form.get('allergies')!.disable();
    this.form.get('diseases')!.disable();
    this.form.get('injuryHistory')!.disable();
    this.form.get('medication')!.disable();
  }

  close() {
    this.dialogRef.close();
  }
}

@Component({
  templateUrl: './masked-patient-dialog.html',
  styleUrls: ['./../home/home.component.css']
})
export class MaskedDetails implements OnInit {
  form: FormGroup = new FormGroup({
    patientName: new FormControl(''),
    bloodgroup: new FormControl(''),
    allergies: new FormControl(''),
    medication: new FormControl(''),
  });
  constructor(public dialogRef: MatDialogRef<PatientInfoDetails>, @Inject(MAT_DIALOG_DATA) public data: any,) { }
  ngOnInit(): void {
    this.form.get('patientName')!.setValue(this.data.patientName);
    this.form.get('bloodgroup')!.setValue(this.data.bloodGroup);
    this.form.get('allergies')!.setValue(this.data.allergies);
    this.form.get('medication')!.setValue(this.data.medication);

    this.form.get('patientName')!.disable();
    this.form.get('bloodgroup')!.disable();
    this.form.get('allergies')!.disable();
    this.form.get('medication')!.disable();
  }

  close() {
    this.dialogRef.close();
  }
}