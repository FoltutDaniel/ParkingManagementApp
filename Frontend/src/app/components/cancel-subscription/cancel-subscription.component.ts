import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-cancel-subscription',
  templateUrl: './cancel-subscription.component.html',
  styleUrls: ['./cancel-subscription.component.css']
})
export class CancelSubscriptionComponent implements OnInit {

  cancelSubscriptionForm = new FormGroup({
    licensePlate: new FormControl(''),
    password: new FormControl('')
  })

  numberPlates: string[] = [];
  constructor() { }

  ngOnInit(): void {
  }

  getData(){

  }

}
