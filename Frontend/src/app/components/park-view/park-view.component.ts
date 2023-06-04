import { Component, OnInit } from '@angular/core';
import { ParkingLot } from 'src/app/common/parking-lot';
import { ParkingLotService } from 'src/app/services/parking-lot.service';

@Component({
  selector: 'app-park-view',
  templateUrl: './park-view.component.html',
  styleUrls: ['./park-view.component.css']
})
export class ParkViewComponent implements OnInit {

  parkingLots: ParkingLot[] = [];
  admin: boolean = false;
  constructor(private parkingService: ParkingLotService) { }

  ngOnInit(): void {
    this.parkingService.getAllParkingLots().then(
      (res)=>{
        this.parkingLots = res;
      },
      (err)=>{
        alert('Parking Lots load error');
      }
    )
  }

}
