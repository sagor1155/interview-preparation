package org.example.kafkaproducer.service;

import org.example.kafkaproducer.dto.Customer;
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

    public void sendCustomObject(Customer customer) {
        try {
            CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("demo4", customer);
            future.whenComplete((result, ex) -> {
                if (ex != null) {
                    System.out.println("Unable to send object=[" + customer + "] due to: " + ex.getMessage());
                } else {
                    System.out.println("Sent object=[" + customer + "] with offset=[" +
                            result.getRecordMetadata().offset() + "]");
                }
            });
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}
