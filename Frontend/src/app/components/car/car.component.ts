import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

  constructor() { }
  parked: Boolean = false;
  brand: String = "bmw";

  ngOnInit(): void {
  }

}
