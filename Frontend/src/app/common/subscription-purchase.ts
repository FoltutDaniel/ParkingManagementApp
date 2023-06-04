export class SubscriptionPurchase {
    subscriptionType!: number;
    startDate!: string;
    licensePlate!: string;
    userId!: number;

    constructor(subscriptionType: number, startDate: string, numberPlate: string, userId: number){
        this.subscriptionType = subscriptionType;
        this.startDate = startDate;
        this.licensePlate = numberPlate;
        this.userId = userId;
    }
}
