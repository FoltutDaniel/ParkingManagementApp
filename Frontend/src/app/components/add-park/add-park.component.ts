import { Component, OnInit } from '@angular/core';
import {RegisterPark} from "../../common/register-park";
import {ParkingLotService} from "../../services/parking-lot.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-park',
  templateUrl: './add-park.component.html',
  styleUrls: ['./add-park.component.css']
})
export class AddParkComponent implements OnInit {

  carBrands: string[] = [];
  constructor(private parkingService: ParkingLotService, private router: Router) { }

  ngOnInit(): void {
  }

  getData(){
    let name = (document.getElementById('name') as HTMLInputElement).value;
    let address = (document.getElementById('address') as HTMLInputElement).value;
    let latitude = (document.getElementById('latitude') as HTMLInputElement).value;
    let longitude = (document.getElementById('longitude') as HTMLInputElement).value;
    let max_capacity = (document.getElementById('max_capacity') as HTMLInputElement).value;

    const registerPark: RegisterPark = new RegisterPark(name, address, latitude, longitude, Number(max_capacity));
    this.parkingService.addParkingLot(registerPark).then(
      (res)=>{
        this.router.navigateByUrl('');
      },(err)=>{
        alert('Adding park failed');
      }
    );
  }

}
