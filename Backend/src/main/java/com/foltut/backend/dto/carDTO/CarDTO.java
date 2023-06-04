package com.foltut.backend.dto.carDTO;

import com.foltut.backend.dto.ParkingLotDTO.ParkingLotDTO;
import com.foltut.backend.dto.subscriptionDTO.SubscriptionDTO;
import com.foltut.backend.dto.userDTO.UserDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDTO {

    private Long id;

    private String licensePlate;

    private String brand;

    private Boolean parkingStatus;

    private SubscriptionDTO subscriptionDTO;

    private ParkingLotDTO parkingLotDTO;

}
