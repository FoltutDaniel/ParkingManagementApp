package com.foltut.backend.dto.carDTO;

import com.foltut.backend.dto.ParkingLotDTO.ParkingLotDTO;
import com.foltut.backend.dto.subscriptionDTO.SubscriptionDTO;
import com.foltut.backend.dto.userDTO.UserDTO;

public class CarDTO {

    private Long id;

    private String licensePlate;

    private String brand;

    private Boolean parkingStatus;

    private SubscriptionDTO subscriptionDTO;

    private ParkingLotDTO parkingLotDTO;


    public CarDTO() {
    }

    public CarDTO(Long id, String licensePlate, String brand, Boolean parkingStatus, SubscriptionDTO subscriptionDTO, ParkingLotDTO parkingLotDTO) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.parkingStatus = parkingStatus;
        this.subscriptionDTO = subscriptionDTO;
        this.parkingLotDTO = parkingLotDTO;
    }


    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(Boolean parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public SubscriptionDTO getSubscriptionDTO() {
        return subscriptionDTO;
    }

    public void setSubscriptionDTO(SubscriptionDTO subscriptionDTO) {
        this.subscriptionDTO = subscriptionDTO;
    }

    public ParkingLotDTO getParkingLotDTO() {
        return parkingLotDTO;
    }

    public void setParkingLotDTO(ParkingLotDTO parkingLotDTO) {
        this.parkingLotDTO = parkingLotDTO;
    }
}
