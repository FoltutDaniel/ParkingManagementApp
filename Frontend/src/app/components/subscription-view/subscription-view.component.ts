import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-subscription-view',
  templateUrl: './subscription-view.component.html',
  styleUrls: ['./subscription-view.component.css']
})
export class SubscriptionViewComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  selectSubscription(subscriptionType: number){
    sessionStorage.setItem('subscriptionType', subscriptionType + '');
    this.router.navigateByUrl('/confirm-subscription');
  }

}
