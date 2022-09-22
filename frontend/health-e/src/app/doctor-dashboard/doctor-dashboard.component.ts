import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { PatientInfoDialog } from '../home/home.component';

@Component({
  selector: 'app-doctor-dashboard',
  templateUrl: './doctor-dashboard.component.html',
  styleUrls: ['./doctor-dashboard.component.css']
})
export class DoctorDashboardComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  openDialog(){
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

  constructor(public dialogRef: MatDialogRef<DoctorRequestDialog>) { }

  ngOnInit(): void {
  }
  form: FormGroup = new FormGroup({
    patientid: new FormControl(''),
    doctorid: new FormControl(''),
    reason: new FormControl(''),
    date: new FormControl(''),
    status: new FormControl('')
  });

  submit() {
    console.log("hello");
  //  console.log()
  }

  close(){
    this.dialogRef.close();
  }
}