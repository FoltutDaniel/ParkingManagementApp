package com.foltut.backend.service;

import com.foltut.backend.dto.subscriptionDTO.SubscriptionPurchaseDTO;
import com.foltut.backend.exception.ResourceNotFoundException;
import com.foltut.backend.model.Car;
import com.foltut.backend.model.Subscription;
import com.foltut.backend.model.User;
import com.foltut.backend.repository.CarRepository;
import com.foltut.backend.repository.SubscriptionRepository;
import com.foltut.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private HistoryService historyService;

    public Long purchaseSubscription(SubscriptionPurchaseDTO subscriptionPurchaseDTO){
        Optional<Car> selectedCar = carRepository.findByLicensePlate(subscriptionPurchaseDTO.getLicensePlate());
        User currentUser = userService.getUsernameFromSecurityContext();

        if(!selectedCar.isPresent()){
            throw new ResourceNotFoundException("Car", "Car license plate", subscriptionPurchaseDTO.getLicensePlate());
        }

        Subscription newSubscription = new Subscription();
        newSubscription.setCar(selectedCar.get());
        selectedCar.get().setSubscription(newSubscription);
        newSubscription.setSubscriptionUser(currentUser);
        newSubscription.setStartDate(subscriptionPurchaseDTO.getStartDate());

        switch (subscriptionPurchaseDTO.getSubscriptionType()){
            case 1:
                newSubscription.setEndDate(subscriptionPurchaseDTO.getStartDate().plusMonths(1));
                newSubscription.setPrice(100d);
                break;
            case 2:
                newSubscription.setEndDate(subscriptionPurchaseDTO.getStartDate().plusMonths(3));
                newSubscription.setPrice(90d);
                break;
            case 3:
                newSubscription.setEndDate(subscriptionPurchaseDTO.getStartDate().plusMonths(6));
                newSubscription.setPrice(80d);
                break;
            case 4:
                newSubscription.setEndDate(subscriptionPurchaseDTO.getStartDate().plusMonths(12));
                newSubscription.setPrice(70d);
                break;
        }

        subscriptionRepository.save(newSubscription);
        return newSubscription.getId();
    }
}
