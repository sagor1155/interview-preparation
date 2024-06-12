package org.example.kafkaconsumer.service;

import org.example.kafkaconsumer.dto.Customer;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

//    @KafkaListener(topics = "demo3", groupId = "group1")
//    public void consumeMessage1(String message) {
//        System.out.println("Consumer-1 Received message=[" + message + "]");
//    }
//
//    @KafkaListener(topics = "demo3", groupId = "group1")
//    public void consumeMessage2(String message) {
//        System.out.println("Consumer-2 Received message=[" + message + "]");
//    }
//
//    @KafkaListener(topics = "demo3", groupId = "group1")
//    public void consumeMessage3(String message) {
//        System.out.println("Consumer-3 Received message=[" + message + "]");
//    }
//
//    @KafkaListener(topics = "demo3", groupId = "group1")
//    public void consumeMessage4(String message) {
//        System.out.println("Consumer-4 Received message=[" + message + "]");
//    }

//    @KafkaListener(topics = "demo4", groupId = "group2")
//    public void consumeObject(Customer customer) {
//        System.out.println("Consumer-5 Received Object=[" + customer + "]");
//    }

    @RetryableTopic(attempts = "4", // N-1 = 3 attempts, creates 3 topic with retry number as suffix
            backoff = @Backoff(delay = 500, multiplier = 1.5, maxDelay = 3000), // delay between retries
            exclude = {NullPointerException.class} // no retry for these exceptions
    )
    @KafkaListener(topics = "demo5", groupId = "group3")
    public void consumeObjectWithErrorHandle(Customer customer,
                                             @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                                             @Header(KafkaHeaders.OFFSET) long offset)
    {
        try {
            System.out.println("Consumer-6 Received Object [Topic=" + topic + ", Offset=" + offset + "] " + customer);
            // simulate error scenario
            if (!customer.getEmail().contains("@")) {
                throw new RuntimeException("Invalid Email Address!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @DltHandler
    public void listenDlt(Customer customer,
                          @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                          @Header(KafkaHeaders.OFFSET) long offset)
    {
        System.out.println("DLT Received [Topic=" + topic + ", Offset=" + offset + "] " + customer);
    }

}
