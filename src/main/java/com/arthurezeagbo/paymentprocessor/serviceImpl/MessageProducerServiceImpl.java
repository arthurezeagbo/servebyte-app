package com.arthurezeagbo.paymentprocessor.serviceImpl;

import com.arthurezeagbo.paymentprocessor.service.MessageProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Slf4j
@Service
public class MessageProducerServiceImpl implements MessageProducerService {

    @Value("${app.kafka.payment.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(500))
    public void processEmailNotification() {

        String message = "Dear Customer, your order was successful. Thank you for your patronage";

        kafkaTemplate.send(topic, message);
        log.info(">>>>>> Email pushed to messaging server");
    }

    @Recover
    public void recoverMessage(){
        log.info(">>>>>Error occurred pushing email to messaging server");
    }



}
