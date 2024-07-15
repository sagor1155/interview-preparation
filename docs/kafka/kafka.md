# KAFKA
- Architecture
- Broker
- Producer
- Consumer
- Consumer Groups
- Partitions
- Consumer Re-balancing
- Fault Tolerance
- Load Distribution
- Serializer and Deserializer
- Error Handling, Retry, Dead Letter Topic
- 

### Refs
- https://www.youtube.com/playlist?list=PLVz2XdJiJQxwpWGoNokohsSW2CysI6lDc


## KAFKA vs RabbitMQ

| Aspect                    | RabbitMQ                                             | Apache Kafka                                        |
|---------------------------|------------------------------------------------------|-----------------------------------------------------|
| **Type**                  | Message Broker                                       | Distributed Streaming Platform                      |
| **Message Model**         | Message Queue with routing capabilities (queues, exchanges, bindings) | Pub/Sub model with distributed log (topics, partitions) |
| **Use Case**              | Traditional messaging, task queue, request/reply, RPC | Event streaming, real-time analytics, log aggregation |
| **Message Persistence**   | Messages are typically kept until acknowledged by consumers | Messages are kept for a configurable retention period regardless of consumption |
| **Message Ordering**      | Ensures message order within a queue                 | Guarantees order within a partition                 |
| **Consumer Model**        | Push-based                                           | Pull-based                                          |
| **Scalability**           | Scales with clustering, but limited compared to Kafka | Highly scalable, designed for high-throughput and horizontal scaling |
| **Performance**           | Suitable for lower throughput, higher latency workloads | Optimized for high throughput and low latency       |
| **Message Retention**     | Messages are removed once consumed (unless persistent) | Messages are retained based on time or size configuration |
| **Delivery Guarantees**   | At most once, at least once, and exactly once (with transactions) | At most once, at least once (exactly once requires additional configuration) |
| **Protocol**              | AMQP, MQTT, STOMP                                    | Custom binary protocol (optimized for performance)  |
