package com.foltut.backend.dto.carDTO;

public class CarRegisterDTO {

    private String licensePlate;

    private String brand;

    private Long ownerId;

    public CarRegisterDTO() {
    }

    public CarRegisterDTO(String licensePlate, String brand, Long ownerId) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.ownerId = ownerId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
