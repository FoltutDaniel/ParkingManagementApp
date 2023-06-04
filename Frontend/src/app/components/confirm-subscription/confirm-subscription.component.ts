import { DatePipe, formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { SubscriptionPurchase } from 'src/app/common/subscription-purchase';
import { CarService } from 'src/app/services/car.service';
import { SubscriptionService } from 'src/app/services/subscription.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-confirm-subscription',
  templateUrl: './confirm-subscription.component.html',
  styleUrls: ['./confirm-subscription.component.css']
})
export class ConfirmSubscriptionComponent implements OnInit {

  numberPlates: String[] = [];
  startDate!: Date;
  subscriptionType!: number;
  subscriptionPrice!: number;
  subscriptionPeriod!: number;

  constructor(private carService: CarService, private subscriptionService: SubscriptionService, private router: Router) { }

  ngOnInit(): void {
    this.subscriptionType = Number(sessionStorage.getItem('subscriptionType'));
    this.carService.getLicensePlates(Number(sessionStorage.getItem('userId'))).then(
      (res)=>{
        this.numberPlates = res;
      },
      (err)=>{
        alert('Number plates import failed');
      }
    );

    switch (this.subscriptionType) {
      case 1:
        this.subscriptionPrice = 100;
        this.subscriptionPeriod = 1;
        break;

      case 2:
        this.subscriptionPrice = 90;
        this.subscriptionPeriod = 3;
        break;

      case 3:
        this.subscriptionPrice = 80;
        this.subscriptionPeriod = 6;
        break;

      case 4:
        this.subscriptionPrice = 70;
        this.subscriptionPeriod = 12;
        break;

      default:
        break;
    }
  }

  purchaseSubscription(){
    let startDate = (document.getElementById('start-date') as HTMLInputElement).value;
    let selectedCarPlate = (document.getElementById('car') as HTMLInputElement).value;
    let userId = Number(sessionStorage.getItem('userId'));

    let subscriptionPurchase = new SubscriptionPurchase(this.subscriptionType, startDate, selectedCarPlate, userId)

    this.subscriptionService.purchaseSubscription(subscriptionPurchase).then(
      (res)=>{
        alert('Subscription purchased succesfully!');
        this.router.navigateByUrl('');
      },
      (err)=>{
        alert("Subscription purchase error!")
      }
    )
  }

}
