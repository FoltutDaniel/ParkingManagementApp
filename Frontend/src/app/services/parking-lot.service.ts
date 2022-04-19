import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ParkingLot } from '../common/parking-lot';

@Injectable({
  providedIn: 'root'
})
export class ParkingLotService {

  baseUrl: string = "http://localhost:8080/parking";

  constructor(private http: HttpClient) { }

  getAllParkingLots(): Promise<ParkingLot[]>{

    return this.http.get<ParkingLot[]>(this.baseUrl+'/all').toPromise();
  }
}
