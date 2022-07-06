import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SubscriptionPurchase } from '../common/subscription-purchase';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {

  baseUrl = "http://localhost:8080/subscription";

  constructor(private http: HttpClient) { }

  purchaseSubscription(subscriptionPurchase: SubscriptionPurchase): Promise<number>{
    return this.http.post<number>(this.baseUrl + '/purchase', subscriptionPurchase).toPromise();
  }

  cancelSubscription(licensePlate: string): Promise<Boolean>{
    return this.http.post<boolean>(this.baseUrl + '/cancel', licensePlate).toPromise();
  }
}
