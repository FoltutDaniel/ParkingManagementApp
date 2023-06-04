package com.foltut.backend.repository;

import com.foltut.backend.model.Car;
import com.foltut.backend.model.Subscription;
import com.foltut.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
    Subscription findByCar(Car car);

    Subscription findBySubscriptionUser(User user);
}
