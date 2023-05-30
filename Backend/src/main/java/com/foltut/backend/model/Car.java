package com.foltut.backend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "parking_status")
    private Boolean parkingStatus;

    @Column(name = "brand")
    private String brand;

    @OneToOne
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    private Subscription subscription;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    public Car() {
    }

    public Car(String licensePlate, String brand, User owner) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public User getOwner() {
        return owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlateNumber) {
        this.licensePlate = licensePlateNumber;
    }

    public Boolean getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(Boolean parkingStatus) {
        this.parkingStatus = parkingStatus;
    }
}
