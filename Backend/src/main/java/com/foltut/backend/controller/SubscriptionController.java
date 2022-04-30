package com.foltut.backend.controller;

import com.foltut.backend.dto.subscriptionDTO.SubscriptionPurchaseDTO;
import com.foltut.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/purchase")
    public Long purchaseSubscription(@RequestBody()SubscriptionPurchaseDTO subscriptionPurchaseDTO){
        return subscriptionService.purchaseSubscription(subscriptionPurchaseDTO);
    }
}
