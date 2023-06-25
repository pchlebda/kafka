package com.example.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "${main.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(Message message) {
        System.out.println("Received: " + message);
    }
}
