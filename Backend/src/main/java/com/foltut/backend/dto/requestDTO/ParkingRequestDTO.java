package com.foltut.backend.dto.requestDTO;

public class ParkingRequestDTO {

    private String licensePlate;

    private Long parkingLotId;

    public ParkingRequestDTO() {
    }

    public ParkingRequestDTO(String licensePlate, Long parkingLotId) {
        this.licensePlate = licensePlate;
        this.parkingLotId = parkingLotId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
