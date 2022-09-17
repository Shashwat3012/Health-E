import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  openDialog(){
   this.dialog.open(PatientInfoDialog, {
    height: '600px',
    width: '600px',
   });
  }

}

@Component({
  selector: 'app-home',
  templateUrl: './patientInfo-dialog.component.html',
  styleUrls: ['./home.component.css']
})
export class PatientInfoDialog implements OnInit {

  constructor(public dialogRef: MatDialogRef<PatientInfoDialog>) { }

  ngOnInit(): void {
  }
  form: FormGroup = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    username: new FormControl(''),
    password: new FormControl(''),
    role: new FormControl('')
  });

  submit() {
    console.log("hello");
  //  console.log()
  }

  close(){
    this.dialogRef.close();
  }
}
