package org.example.kafkaconsumer.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.example.kafkaconsumer.dto.Customer;

public class CustomCustomerDeserializer<T> implements Deserializer<T> {
    private final ObjectMapper objectMapper;

    public CustomCustomerDeserializer() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, (Class<T>) Customer.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing value", e);
        }
    }

}
