import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private userService: UserService,private router:Router) { }

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
    const user ={
      firstName: this.form.get('firstName')!.value,
      lastName: this.form.get('lastName')!.value,
      userName: this.form.get('username')!.value,
      password: this.form.get('password')!.value,
      role: this.form.get('role')!.value,
    }
    this.userService.register(user).subscribe((response) => {
        console.log(response);
    })
  }

  login(){
    this.router.navigate(['/login']);
  }
}
