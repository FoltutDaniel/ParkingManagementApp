import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'
import jwt_decode from 'jwt-decode';
import { LoginData } from '../common/login-data';
import { RegisterData } from '../common/register-data';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl = 'http://localhost:8080';
  constructor(private httpClient: HttpClient, private router: Router) { }

  login(loginData: LoginData): Observable<any>{
    return this.httpClient.post<any>(this.baseUrl + '/user/login', loginData)
    .pipe(
      map(
        (userData) => {
          let tokenStr = userData.token;
          sessionStorage.setItem('token', userData.token);

          let decodedToken = this.getDecodedAccessToken(tokenStr);
          sessionStorage.setItem('username', decodedToken.username);
          sessionStorage.setItem('userId', decodedToken.id);
        }
      )
    )
  }

  register(registerData: RegisterData): Observable<any>{
    return this.httpClient.post<any>(this.baseUrl + "/user/register", registerData);
  }

  getDecodedAccessToken(token: string): any{
    try{
      return jwt_decode(token);
    }catch(Error){
      return null;
    }
  }

  isUserLoggedIn(){
    let user = sessionStorage.getItem('username');
    return !(user === null);
  }

  logOut() {
    sessionStorage.clear();
    this.router.navigateByUrl('/login');
  }


}
