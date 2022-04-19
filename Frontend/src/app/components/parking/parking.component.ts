import { Component, Input, OnInit } from '@angular/core';
import { reduce } from 'rxjs/operators';
import * as L from 'leaflet';
import { ParkingLot } from 'src/app/common/parking-lot';


@Component({
  selector: 'app-parking',
  templateUrl: './parking.component.html',
  styleUrls: ['./parking.component.css']
})
export class ParkingComponent implements OnInit {
  
  @Input()
  parkingLot!: ParkingLot;

  color: string = 'yellow';

  parkingSpots!: number;


  constructor() { }

  ngOnInit(): void {
    this.parkingSpots = this.parkingLot.maxCapacity - this.parkingLot.parkingSpotsOccupied;

    if(this.parkingSpots == 0){
      this.color = '#9d001f';
      this.parkingSpots = 0;
    }else{
      this.color = '#007a49';
    }
  }

}
