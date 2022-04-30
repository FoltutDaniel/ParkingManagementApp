import { Component, OnInit } from '@angular/core';
import { Car } from 'src/app/common/car';
import { CarService } from 'src/app/services/car.service';

@Component({
  selector: 'app-home-view',
  templateUrl: './home-view.component.html',
  styleUrls: ['./home-view.component.css']
})
export class HomeViewComponent implements OnInit {

  ownedCars: Car[] = [];
  userId: number = Number(sessionStorage.getItem('userId'));
  constructor(private carService: CarService) { }

  ngOnInit(): void {
     this.carService.getCarsForUser(this.userId).then(
       (res)=>{
        this.ownedCars = res;
        console.log(this.ownedCars);
       },
       (err)=>{
         alert('Users cars could not be retrieved');
       }
     )
  }

}
