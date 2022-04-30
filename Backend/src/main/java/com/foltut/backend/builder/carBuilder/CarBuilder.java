package com.foltut.backend.builder.carBuilder;

import com.foltut.backend.builder.parkingLotBuilder.ParkingLotBuilder;
import com.foltut.backend.builder.subscriptionBuilder.SubscriptionBuilder;
import com.foltut.backend.dto.carDTO.CarDTO;
import com.foltut.backend.model.Car;

public class CarBuilder {

    public static CarDTO generateDTOFromEntity(Car car)
    {
        return new CarDTO(
                car.getId(),
                car.getLicensePlate(),
                car.getBrand(),
                car.getParkingStatus(),
                SubscriptionBuilder.generateDTOFromEntity(car.getSubscription()),
                ParkingLotBuilder.generateDTOFromEntity(car.getParkingLot())
        );
    }
}
