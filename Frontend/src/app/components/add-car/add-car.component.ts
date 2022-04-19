import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-car',
  templateUrl: './add-car.component.html',
  styleUrls: ['./add-car.component.css']
})
export class AddCarComponent implements OnInit {

  carBrands: String[]= [
    'BWM', 'Audi', 'Dacia'
  ];

  constructor() { }

  ngOnInit(): void {
  }

  getData(){
    let numberPlate = (document.getElementById('plate') as HTMLInputElement).value;
    let brand = (document.getElementById('brand') as HTMLInputElement).value;

    console.log(numberPlate + '  ' + brand);
  }
}
