import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ParkingLot } from '../common/parking-lot';
import {RegisterPark} from "../common/register-park";

@Injectable({
  providedIn: 'root'
})
export class ParkingLotService {

  baseUrl: string = "http://localhost:8080/parking";

  constructor(private http: HttpClient) { }

  getAllParkingLots(): Promise<ParkingLot[]>{

    return this.http.get<ParkingLot[]>(this.baseUrl+'/all').toPromise();
  }

  addParkingLot(registerParking: RegisterPark): Promise<ParkingLot>{
    return this.http.post<ParkingLot>(this.baseUrl+'/add-park', registerParking).toPromise();
  }
}
