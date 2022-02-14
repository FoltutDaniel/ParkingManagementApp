package com.foltut.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "license_plate_number")
    private String licensePlateNumber;

    @Column(name = "parking_status")
    private Boolean parkingStatus;

    @OneToOne
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    private Subscription subscription;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public Boolean getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(Boolean parkingStatus) {
        this.parkingStatus = parkingStatus;
    }
}
