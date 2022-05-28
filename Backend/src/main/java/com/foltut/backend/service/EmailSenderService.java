package com.foltut.backend.service;

import com.foltut.backend.model.Subscription;
import com.foltut.backend.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public void sendEmail(String toEmail, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("parkappfoltut@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
    }

    @Scheduled(cron = "0 0 0 */1 * *")
    public void execute(){
        List<Subscription> subscriptionsToExpire = StreamSupport
                .stream(subscriptionRepository.findAll().spliterator(),false)
                .filter(subscription -> subscription.getEndDate().isEqual(LocalDate.now().minusDays(1)))
                .collect(Collectors.toList());

        subscriptionsToExpire
                .forEach(subscription ->
                        sendEmail(subscription.getSubscriptionUser().getEmail(),
                                "Parking subscription expiration reminder",
                                "Your parking subscription will expire tomorrow"));
    }
}
