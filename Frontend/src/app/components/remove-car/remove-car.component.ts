import { Component, OnInit } from '@angular/core';
import { CarService } from 'src/app/services/car.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-remove-car',
  templateUrl: './remove-car.component.html',
  styleUrls: ['./remove-car.component.css']
})
export class RemoveCarComponent implements OnInit {

  numberPlates: String[] = [];
  constructor(private carService: CarService, private router: Router) { }

  ngOnInit(): void {
    this.carService.getLicensePlates(Number(sessionStorage.getItem('userId'))).then(
      (res)=>{
        this.numberPlates = res;
      },
      (err)=>{
        alert('Number plates import failed');
      }
    );
  }

  getData(){
    let numberPlate = (document.getElementById('plate') as HTMLInputElement).value;
    this.carService.removeCar(numberPlate).then(
      (res)=>{
      alert('Car with license plate ' + numberPlate +' has been removed from your account!');
      this.router.navigateByUrl('');
    },(err)=>{
      alert('Car removal error');
    });

  }

}
