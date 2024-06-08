package org.example.kafkaconsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    @KafkaListener(topics = "demo3", groupId = "group1")
    public void consumeMessage1(String message) {
        System.out.println("Consumer-1 Received message=[" + message + "]");
    }

    @KafkaListener(topics = "demo3", groupId = "group1")
    public void consumeMessage2(String message) {
        System.out.println("Consumer-2 Received message=[" + message + "]");
    }

    @KafkaListener(topics = "demo3", groupId = "group1")
    public void consumeMessage3(String message) {
        System.out.println("Consumer-3 Received message=[" + message + "]");
    }

    @KafkaListener(topics = "demo3", groupId = "group1")
    public void consumeMessage4(String message) {
        System.out.println("Consumer-4 Received message=[" + message + "]");
    }
}
