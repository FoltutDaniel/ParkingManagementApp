package com.foltut.backend.builder.parkingLotBuilder;

import com.foltut.backend.dto.ParkingLotDTO.ParkingLotDTO;
import com.foltut.backend.model.ParkingLot;

public class ParkingLotBuilder {

    public static ParkingLot generateEntityFromDTO(ParkingLotDTO parkingLotDTO){
        return new ParkingLot(
                parkingLotDTO.getId(),
                parkingLotDTO.getName(),
                parkingLotDTO.getAddress(),
                parkingLotDTO.getLatitude(),
                parkingLotDTO.getLongitude(),
                parkingLotDTO.getMaxCapacity()
        );
    }
    public static ParkingLotDTO generateDTOFromEntity(ParkingLot parkingLot){
        return new ParkingLotDTO(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getAddress(),
                parkingLot.getLatitude(),
                parkingLot.getLongitude(),
                parkingLot.getMaxCapacity(),
                parkingLot.getCars().size()
        );
    }
}
