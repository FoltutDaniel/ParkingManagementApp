import { Component, OnInit } from '@angular/core';
import { CarRegister } from 'src/app/common/car-register';
import { CarService } from 'src/app/services/car.service';

@Component({
  selector: 'app-add-car',
  templateUrl: './add-car.component.html',
  styleUrls: ['./add-car.component.css']
})
export class AddCarComponent implements OnInit {

  carBrands: String[]= [
    'BWM', 'Audi', 'Dacia'
  ];

  constructor(private carService: CarService) { }

  ngOnInit(): void {
  }

  getData(){
    let numberPlate = (document.getElementById('plate') as HTMLInputElement).value;
    let brand = (document.getElementById('brand') as HTMLInputElement).value;
    let ownerId = sessionStorage.getItem('userId');

    this.carService.registerCar(new CarRegister(numberPlate, brand, Number(ownerId))).then(
      (res)=>{
        alert('Car registered succesfully');
      },
      (err) => {
        alert('Car registration failed!');
      }
    );
  }
}
