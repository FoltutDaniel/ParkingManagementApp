import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ChangeEmailRequest } from '../common/change-email-request';
import { ChangePasswordRequest } from '../common/change-password-request';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = "http://localhost:8080/user";

  constructor(private http: HttpClient) { }

  changeEmail(changeEmailRequest: ChangeEmailRequest): Promise<boolean>{
    return this.http.post<boolean>(this.baseUrl + '/changeEmail', changeEmailRequest).toPromise();
  }

  changePassword(changePasswordRequest: ChangePasswordRequest): Promise<boolean>{
    return this.http.post<boolean>(this.baseUrl + '/changePassword', changePasswordRequest).toPromise();
  }


}
