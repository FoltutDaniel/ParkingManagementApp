import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
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
  
  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  login(){
    let loginData: LoginData = new LoginData();
    loginData = this.loginForm.value;
    this.authService.login(loginData).subscribe(
      (res)=>{
        this.router.navigateByUrl('/main');
      },
      (err)=>{
        alert(`Login failed`);
      }
    );
  }

}
