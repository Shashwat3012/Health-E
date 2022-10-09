import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  roles = ['Patient', 'Doctor'];
  constructor(private router: Router, private userService: UserService,
    private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }
  form: FormGroup = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    role: new FormControl(''),
    patientId: new FormControl(''),
    nomineeName: new FormControl(''),
    license: new FormControl('')
  });

  submit() {
    if (this.form.get('role')!.value != 'Admin') {
      const user = {
        userName: this.form.get('username')!.value || "",
        password: this.form.get('password')!.value || "",
        role: this.form.get('role')!.value || "",
        patientId: this.form.get('patientId')!.value || "",
        nomineeName: this.form.get('nomineeName')!.value || "",
        license: this.form.get('license')!.value || ""
      }
      this.userService.login(user).subscribe((response) => {

        if (user.role == "Patient") {
          sessionStorage.setItem("userId", response);
          sessionStorage.setItem("role", user.role);
          this.router.navigate(['/home']);
          this._snackBar.open("Login Successful", "Close", {
            duration: 1500,
          });
        }
        if (user.role == "Doctor") {
          if (response == "User Not Found!") {
            this._snackBar.open("User Not Found!", "Close", {
              duration: 1500,
            });
          } 
          if(response == "Status Pending"){
            this._snackBar.open("Registration not approved", "Close", {
              duration: 1500,
            });
          }
          else {
            this._snackBar.open("Login Successful", "Close", {
              duration: 1500,
            });
            sessionStorage.setItem("userId", response);
            sessionStorage.setItem("role", user.role);
            this.router.navigate(['/doctor-dashboard'])
          }

        }
        if (user.role == "Nominee") {
          this._snackBar.open("Login Successful", "Close", {
            duration: 1500,
          });
          sessionStorage.setItem("userId", user.patientId);
          sessionStorage.setItem("role", user.role);
          this.router.navigate(['/nominee-dashboard']);
        }
      })
    } else {
      this._snackBar.open("Login Successful", "Close", {
        duration: 1500,
      });
      sessionStorage.setItem("role", "Admin");
      this.router.navigate(['/admin-dashboard']);
    }
    //  console.log()
  }

  register() {
    this.router.navigate(['/register']);
  }
}
