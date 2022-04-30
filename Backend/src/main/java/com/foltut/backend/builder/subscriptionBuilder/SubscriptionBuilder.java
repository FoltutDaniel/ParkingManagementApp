package com.foltut.backend.builder.subscriptionBuilder;

import com.foltut.backend.dto.subscriptionDTO.SubscriptionDTO;
import com.foltut.backend.model.Subscription;

public class SubscriptionBuilder {

    public static SubscriptionDTO generateDTOFromEntity(Subscription subscription){
        if(subscription!=null) {
            return new SubscriptionDTO(
                    subscription.getId(),
                    subscription.getPrice(),
                    subscription.getStartDate(),
                    subscription.getEndDate()
            );
        }
        return null;
    }
}
