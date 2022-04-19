import { AfterViewInit, Component, Input, OnInit } from '@angular/core';
import * as L from 'leaflet';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements AfterViewInit {

  @Input()
  Id!: number;

  @Input()
  latitude!: String;

  @Input()
  longitutde!: String;

  constructor() { }

  private map: any;

  private initMap(): void {
    this.map = L.map('map'+this.Id, {
      center: [ +this.latitude, +this.longitutde ],
      zoom: 18
    });

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 18,
      minZoom: 3,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);
  }
  

 

  ngAfterViewInit(): void {
    this.initMap();
  }


}
