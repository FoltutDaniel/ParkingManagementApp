export class CarRegister {

    licensePlate!: string;
    brand!: string;
    ownerId!: number;

    constructor(licensePlate: string, brand: string, ownerId: number){
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.ownerId = ownerId;
    }
}
