package com.arthurezeagbo.paymentprocessor.serviceImpl;

import com.arthurezeagbo.paymentprocessor.service.MessageConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageConsumerServiceImpl implements MessageConsumerService {

    final private String topic = "payment_topic";

    @Override
    @KafkaListener(topics = topic, groupId = "payment_group_id")
    public void sendEmail(String message) {
        log.info("NOTIFICATION : {}", message);
    }

}
