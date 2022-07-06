import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ChangeEmailRequest } from 'src/app/common/change-email-request';
import { UserService } from 'src/app/services/user.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-change-email',
  templateUrl: './change-email.component.html',
  styleUrls: ['./change-email.component.css']
})
export class ChangeEmailComponent implements OnInit {

  changeEmailForm = new FormGroup({
    oldEmail: new FormControl(''),
    newEmail: new FormControl(''),
    password: new FormControl('')
  });

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  getData(){
    let changeEmailRequest: ChangeEmailRequest = this.changeEmailForm.value;
    this.userService.changeEmail(changeEmailRequest).then(
      (res)=>{
        if(res == true){
          alert("Email changed succesfully");
          this.router.navigateByUrl('');
        }else{
          alert("Wrong old password");
        }
      }
    )
  }
}
