package com.foltut.backend.dto.subscriptionDTO;

import java.time.LocalDate;

public class SubscriptionPurchaseDTO {
    private LocalDate startDate;

    private Integer subscriptionType;

    private String licensePlate;

    private Long userId;

    public SubscriptionPurchaseDTO() {
    }

    public SubscriptionPurchaseDTO(LocalDate startDate, Integer subscriptionType, String licensePlate, Long userId) {
        this.startDate = startDate;
        this.subscriptionType = subscriptionType;
        this.licensePlate = licensePlate;
        this.userId = userId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(Integer subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
