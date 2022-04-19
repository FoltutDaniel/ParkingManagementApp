import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-remove-car',
  templateUrl: './remove-car.component.html',
  styleUrls: ['./remove-car.component.css']
})
export class RemoveCarComponent implements OnInit {

  numberPlates: String[] = [
    'BH 08 JCC',
    'BH 09 FFE'
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
