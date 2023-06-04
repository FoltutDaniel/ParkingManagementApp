import {max} from "rxjs/operators";

export class RegisterPark {
  name!: string;
  address!: string;
  latitude!: string;
  longitude!: string;
  maxCapacity!: number;

  constructor(name: string, address: string, latitude: string, longitude: string, max_capacity: number) {
    this.name = name;
    this.address = address;
    this.latitude = latitude;
    this.longitude = longitude;
    this.maxCapacity = max_capacity;
  }
}
