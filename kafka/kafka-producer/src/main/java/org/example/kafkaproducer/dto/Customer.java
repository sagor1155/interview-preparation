package org.example.kafkaproducer.dto;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String name;
    private String email;
}
