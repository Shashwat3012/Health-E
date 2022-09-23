import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
roles = ['Patient', 'Doctor'];
  constructor(private router: Router,private userService: UserService) { }

  ngOnInit(): void {
  }
  form: FormGroup = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    role: new FormControl('')
  });

  submit() {
    const user ={
      userName: this.form.get('username')!.value,
      password: this.form.get('password')!.value,
      role: this.form.get('role')!.value,
    }
    this.userService.login(user).subscribe((response) => {
        console.log(response);
        if(user.role=="Patient"){
          this.router.navigate(['/home']);
        }
        else{
          this.router.navigate(['/doctor-dashboard'])
        }
    })
  //  console.log()
  }
}
