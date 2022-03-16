import { Component, Input, OnInit } from '@angular/core';
import { reduce } from 'rxjs/operators';
import * as L from 'leaflet';


@Component({
  selector: 'app-parking',
  templateUrl: './parking.component.html',
  styleUrls: ['./parking.component.css']
})
export class ParkingComponent implements OnInit {
  
  @Input()
  Id!: number;

  color: string = 'yellow';

  parkingSpots: number = 20;


  constructor() { }

  ngOnInit(): void {
    if(this.Id == 2){
      this.color = '#9d001f';
      this.parkingSpots = 0;
    }else{
      this.color = '#007a49';
    }
  }

}
