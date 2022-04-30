import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Car } from '../common/car';
import { CarRegister } from '../common/car-register';

@Injectable({
  providedIn: 'root'
})
export class CarService {
  baseUrl = "http://localhost:8080/car";
  
  constructor(private http: HttpClient) { }

  registerCar(car: CarRegister): Promise<number>{
    return this.http.post<number>(this.baseUrl + '/register', car).toPromise();
  }

  removeCar(licensePlate: string): Promise<any>{
    return this.http.delete<number>(this.baseUrl + '/' + licensePlate,{headers: {'Content-Type': 'application/json'}}).toPromise();
  }

  getLicensePlates(userId: number): Promise<string[]>{
    return this.http.get<string[]>(this.baseUrl + "/getPlates/" + userId).toPromise();
  }

  getCarsForUser(userId: number): Promise<Car[]>{
    return this.http.get<Car[]>(this.baseUrl+"/all/" + userId).toPromise();
  }
  
}
