package com.foltut.backend.repository;

import com.foltut.backend.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
}
