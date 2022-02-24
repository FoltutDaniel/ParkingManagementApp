import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
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
    username: new FormControl(''),
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl('')
  });
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  register(){
    let registerData: RegisterData = new RegisterData();
    registerData = this.registerForm.value;
    
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
