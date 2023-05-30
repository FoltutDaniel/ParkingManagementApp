package com.foltut.backend.builder.carBuilder;

import com.foltut.backend.builder.parkingLotBuilder.ParkingLotBuilder;
import com.foltut.backend.builder.subscriptionBuilder.SubscriptionBuilder;
import com.foltut.backend.dto.carDTO.CarDTO;
import com.foltut.backend.model.Car;

public class CarBuilder {

    public static CarDTO generateDTOFromEntity(Car car) {
        return CarDTO.builder()
                .id(car.getId())
                .licensePlate(car.getLicensePlate())
                .brand(car.getBrand())
                .parkingStatus(car.getParkingStatus())
                .subscriptionDTO(SubscriptionBuilder.generateDTOFromEntity(car.getSubscription()))
                .parkingLotDTO(ParkingLotBuilder.generateDTOFromEntity(car.getParkingLot()))
                .build();

    }
}
