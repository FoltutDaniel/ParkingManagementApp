import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-confirm-subscription',
  templateUrl: './confirm-subscription.component.html',
  styleUrls: ['./confirm-subscription.component.css']
})
export class ConfirmSubscriptionComponent implements OnInit {

  carPlates: String[] = ["BH 08 JCC",
"BH 09 FFE"];
  constructor() { }

  ngOnInit(): void {
  }

}
