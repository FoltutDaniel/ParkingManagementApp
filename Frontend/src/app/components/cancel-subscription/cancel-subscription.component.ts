import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {CarService} from "../../services/car.service";
import {SubscriptionService} from "../../services/subscription.service";
import {Router} from "@angular/router";

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
  constructor(private carService: CarService, private subscriptionService: SubscriptionService, private router: Router) { }

  ngOnInit(): void {
    this.carService.getCarsWithSubscription(Number(sessionStorage.getItem('userId'))).then(
      data=>{
        this.numberPlates = data;
      }
    )
  }

  getData(){
    this.subscriptionService.cancelSubscription((document.getElementById('plate') as HTMLInputElement).value).then(
      data => {
        this.router.navigateByUrl('/home');
      }
    )
  }

}
