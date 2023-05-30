import { Component, OnInit } from '@angular/core';
import {CarService} from "../../services/car.service";
import {SubscriptionService} from "../../services/subscription.service";
import {Router} from "@angular/router";
import {SubscriptionPurchase} from "../../common/subscription-purchase";

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  numberPlates: String[] = [];
  subscriptionType!: number;

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
  }

  purchaseSubscription(){
    let selectedCarPlate = (document.getElementById('car') as HTMLInputElement).value;
    let userId = Number(sessionStorage.getItem('userId'));

    let subscriptionPurchase = new SubscriptionPurchase(5, new Date().toISOString().slice(0, 10), selectedCarPlate, userId)

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
