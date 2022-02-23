import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { LoginData } from 'src/app/common/login-data';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });
  
  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  login(){
    let loginData: LoginData = new LoginData();
    loginData = this.loginForm.value;
    this.authService.login(loginData).subscribe(
      (res)=>{
        alert(`User logged in`);
      },
      (err)=>{
        alert(`Login failed`);
      }
    );
  }

}
