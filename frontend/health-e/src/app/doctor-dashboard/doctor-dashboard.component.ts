import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ConnectableObservable } from 'rxjs';
import { PatientInfoDialog } from '../home/home.component';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-doctor-dashboard',
  templateUrl: './doctor-dashboard.component.html',
  styleUrls: ['./doctor-dashboard.component.css']
})
export class DoctorDashboardComponent implements OnInit {

  constructor(public dialog: MatDialog, private userService: UserService) { }

  ngOnInit(): void {
    this.fetchPatient();
  }
  fetchPatient(){
    const patientId = '1bb37d';
    this.userService.fetchPatient(patientId).subscribe((response) => {
      console.log(response);
  })
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

  constructor(public dialogRef: MatDialogRef<DoctorRequestDialog>, private userService: UserService) { }

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
      patientid: this.form.get('patientid')!.value,
      doctorid: this.form.get('doctorid')!.value,
      reason: this.form.get('reason')!.value,
      date: this.form.get('date')!.value,
      status: "Pending"
    }

    this.userService.requestData(request).subscribe((response) => {
      console.log(response);
  })
  }

  close(){
    this.dialogRef.close();
  }
}