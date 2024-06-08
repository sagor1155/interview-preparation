package org.example.kafkaproducer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaMessagePublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("demo3", message);
        future.whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Unable to send message=[" + message + "] due to: " + ex.getMessage());
            } else {
                System.out.println("Sent message=[" + message + "] with offset=[" +
                        result.getRecordMetadata().offset() + "]");
            }
        });
    }
}
