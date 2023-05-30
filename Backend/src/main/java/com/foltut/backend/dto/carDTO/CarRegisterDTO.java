package com.foltut.backend.dto.carDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarRegisterDTO {

    private String licensePlate;

    private String brand;

    private Long ownerId;
}
