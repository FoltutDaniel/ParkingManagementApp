package com.foltut.backend.service;

import com.foltut.backend.dto.subscriptionDTO.SubscriptionPurchaseDTO;
import com.foltut.backend.model.Car;
import com.foltut.backend.model.Subscription;
import com.foltut.backend.model.User;
import com.foltut.backend.repository.CarRepository;
import com.foltut.backend.repository.SubscriptionRepository;
import com.foltut.backend.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
class SubscriptionServiceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setupData(){

        jdbcTemplate.execute("insert into user_table(id, username, first_name, last_name, email, password)" +
                " values(5, 'UserTest', 'User', 'Test', 'test@mail.com', 'password')");
        jdbcTemplate.execute("INSERT INTO car (`id`, `brand`, `license_plate`, `parking_status`, `user_id`) " +
                "VALUES (6, 'bmw', 'BH09JCC', false, 5)");


    }

    @AfterEach
    public void destroyData(){
        jdbcTemplate.execute("DELETE FROM history");
        jdbcTemplate.execute("DELETE FROM user_table;");
    }

    @Test
    void purchaseSubscription() {
        subscriptionService.purchaseSubscription(new SubscriptionPurchaseDTO(LocalDate.now(), 1, "BH09JCC", 5l));
        Optional<User> user = userRepository.findById(5l);
        Subscription subscription = subscriptionRepository.findBySubscriptionUser(user.get());

        assertEquals(subscription.getSubscriptionUser(), user.get());
    }
}