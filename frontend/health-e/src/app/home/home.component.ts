import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  openDialog() {
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
      patientName: this.form.get('firstName')!.value + this.form.get('lastName')!.value,
      patientId: sessionStorage.getItem("patientId"),
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
    })
  }

  close() {
    this.dialogRef.close();
  }
}
