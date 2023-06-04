import { Component, OnInit } from '@angular/core';
import { CarRegister } from 'src/app/common/car-register';
import { CarService } from 'src/app/services/car.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-car',
  templateUrl: './add-car.component.html',
  styleUrls: ['./add-car.component.css']
})
export class AddCarComponent implements OnInit {

  carBrands: String[]= [
    'BMW', 'Audi', 'Dacia'
  ];

  constructor(private carService: CarService, private router: Router) { }

  ngOnInit(): void {
  }

  getData(){
    let numberPlate = (document.getElementById('plate') as HTMLInputElement).value.replace(/\s/g, "");
    let brand = (document.getElementById('brand') as HTMLInputElement).value.toLowerCase();
    let ownerId = sessionStorage.getItem('userId');

    this.carService.registerCar(new CarRegister(numberPlate, brand, Number(ownerId))).then(
      (res)=>{
        alert('Car registered succesfully');
        this.router.navigateByUrl('');
      },
      (err) => {
        alert('Car registration failed!');
      }
    );
  }
}
