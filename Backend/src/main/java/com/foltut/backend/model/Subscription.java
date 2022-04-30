package com.foltut.backend.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private Double price;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToOne(mappedBy = "subscription")
    private Car car;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User subscriptionUser;

    public Subscription() {
    }

    public Subscription(Long id, Double price, LocalDate startDate, LocalDate endDate, Car car, User subscriptionUser) {
        this.id = id;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.car = car;
        this.subscriptionUser = subscriptionUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getSubscriptionUser() {
        return subscriptionUser;
    }

    public void setSubscriptionUser(User subscriptionUser) {
        this.subscriptionUser = subscriptionUser;
    }
}
