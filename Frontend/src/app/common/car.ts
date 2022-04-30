import { ParkingLot } from "./parking-lot";
import { Subscription } from "./subscription";

export class Car {

    id!: number;
    licensePlate!: string;
    brand!: string;
    parkingStatus!: boolean;
    subscriptionDTO!: Subscription;
    parkingLotDTO!: ParkingLot;
}
