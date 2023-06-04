import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterData } from 'src/app/common/register-data';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm = new FormGroup({
    username: new FormControl('', Validators.required),
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required])
  });
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  get username(){
    return this.registerForm.get('username');
  }

  get firstName(){
    return this.registerForm.get('firstName');
  }

  get lastName(){
    return this.registerForm.get('lastName');
  }

  get email(){
    return this.registerForm.get('email');
  }

  get password(){
    return this.registerForm.get('password');
  }

  register(){
    let registerData : RegisterData = this.registerForm.value;

    this.authService.register(registerData).subscribe(
      (res)=>{
        alert(`User registration was succesfull!`);
        this.router.navigateByUrl('/login');
      },
      (err)=>{
        alert(`Registration failed`);
      }
    );
  }
}
