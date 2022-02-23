import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginData } from '../common/login-data';
import { RegisterData } from '../common/register-data';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl = 'http://localhost:8080';
  constructor(private httpClient: HttpClient) { }

  login(loginData: LoginData): Observable<any>{
    return this.httpClient.post<any>(this.baseUrl + '/user/login', loginData);
  }

  register(registerData: RegisterData): Observable<any>{
    return this.httpClient.post<any>(this.baseUrl + "/user/register", registerData);
  }
}
