package com.foltut.backend.dto.subscriptionDTO;

import com.foltut.backend.dto.carDTO.CarDTO;
import com.foltut.backend.dto.userDTO.UserDTO;

import java.time.LocalDate;

public class SubscriptionDTO {

    private Long id;

    private Double price;

    private LocalDate startDate;

    private LocalDate endDate;


    public SubscriptionDTO(Long id, Double price, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public SubscriptionDTO() {
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
}
