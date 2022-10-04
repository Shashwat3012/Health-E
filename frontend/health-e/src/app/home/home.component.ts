import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormControl, Form } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
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
  constructor(public dialog: MatDialog, private userService: UserService) { }

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
      console.log(response);
    })
  }

}

@Component({
  selector: 'app-home',
  templateUrl: './patientInfo-dialog.component.html',
  styleUrls: ['./home.component.css']
})
export class PatientInfoDialog implements OnInit {

  constructor(public dialogRef: MatDialogRef<PatientInfoDialog>, private userService: UserService) { }

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
  });

  submit() {
    const user = {
      patientName: this.form.get('firstName')!.value +" " + this.form.get('lastName')!.value,
      patientId: sessionStorage.getItem("userId"),
      dob: this.form.get('dob')!.value,
      height: this.form.get('height')!.value,
      weight: this.form.get('weight')!.value,
      bloodGroup: this.form.get('bloodgroup')!.value,
      allergies: this.form.get('allergies')!.value,
      disease: this.form.get('diseases')!.value,
      injuryHistory: this.form.get('injuryHistory')!.value,
      medication: this.form.get('medication')!.value
    }
    this.userService.submitPatientData(user).subscribe((response) => {
      console.log(response);
      this.dialogRef.close();
    })
  }

  close() {
    this.dialogRef.close();
  }
}
