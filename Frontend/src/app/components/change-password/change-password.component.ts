import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ChangePasswordRequest } from 'src/app/common/change-password-request';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  changePasswordForm = new FormGroup({
    oldPassword: new FormControl(''),
    newPassword: new FormControl('')
  })

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  getData(){
    let changePasswordRequest: ChangePasswordRequest = this.changePasswordForm.value;
    this.userService.changePassword(changePasswordRequest).then(
      (res)=>{
        if(res == true){
          alert("Password changed succesfully");
        }else{
          alert("Wrong old password");
        }
      },
      (err)=>{
        alert("Wrong old password");
      }
    )
  }
}
