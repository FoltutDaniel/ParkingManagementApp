package com.foltut.backend.dto.ParkingLotDTO;

public class ParkingLotDTO {

    private Long id;

    private String name;

    private String address;

    private String latitude;

    private String longitude;

    private Integer maxCapacity;

    private Integer parkingSpotsOccupied;

    public ParkingLotDTO() {
    }

    public ParkingLotDTO(Long id, String name, String address, String latitude, String longitude, Integer maxCapacity, Integer parkingSpotsOccupied) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.maxCapacity = maxCapacity;
        this.parkingSpotsOccupied = parkingSpotsOccupied;
    }

    public ParkingLotDTO(Long id, String name, String address, String latitude, String longitude, Integer maxCapacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.maxCapacity = maxCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Integer getParkingSpotsOccupied() {
        return parkingSpotsOccupied;
    }

    public void setParkingSpotsOccupied(Integer parkingSpotsOccupied) {
        this.parkingSpotsOccupied = parkingSpotsOccupied;
    }
}
