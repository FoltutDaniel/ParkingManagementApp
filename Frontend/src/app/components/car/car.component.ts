import { Component, Input, OnInit } from '@angular/core';
import { Car } from 'src/app/common/car';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

  @Input()
  car!: Car;

  noSubscription: boolean = false;;

  parkingLotName: string = 'Away';

  constructor() { }

  ngOnInit(): void {
    if(this.car.parkingLotDTO != null){
      this.parkingLotName = this.car.parkingLotDTO.name;
    }

    if(this.car.subscriptionDTO == null){
      this.noSubscription = true;
    }
  }

}
