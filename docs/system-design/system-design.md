# System Design
- Requirement Analysis
- API
- Security
- Scalability
- Availability
- Communication
- Microservice
- Service Oriented Architecture (SOA)
- Database Selection
- Caching
- CAP Theorem
- Others: Consistent hashing, rate limiting
- Deployment
- Monitoring, Logging, Tracing
- Designing Systems


## Requirement analysis
- Functional
  - Use cases
  - User requirements
- Non-Functional
    - Security
    - Scalability
    - Availability
    - Performance
    - Low Latency
    - Consistency
    - Accuracy
- Use case
- Domain design
- Domain relations
- Domain/Service communication pattern
- 


## API
- REST API
- GraphQL
- gRPC


## Security
- External security
- Internal
- Service-to-service communication
- Data access: Limited response, GraphQL
- DDoS attack, PCI-DSS, OWASP top 10 guideline/principle, Cross site scripting, SQL Injection,

### External Security
- CORS
- HTTPS (TLS, Certificate)
- API Gateway
- AWS Route53
- Security group

### Internal Security
- Request rate limiting to prevent DDoS attack by malicious users
- JWT
- OAuth2
- Multi-factor authentication
- SQL Injection
- Payload validation
- DTO mapping (no need to expose all entity/table data)
- Password encoding
- Salting for password protection

### Service-to-Service Communication Security
- Private communication within VPC
- No need to publicly expose the private services


## Scalability
- Vertical Scaling
- Horizontal Scaling

## Communication
- Synchronous
- Asynchronous

### Synchronous

### Asynchronous
- Message Broker
  - RabbitMQ
  - Kafka

## Microservice
- API gateway (Zuul)
- Configuration service
- Registry service (Eureka Discovery Service)
- Load balancer (Ribbon)
- Fault tolerance (Hystrix, Resilience4j, Circuit breaker pattern)
- Distributed tracing (Zipkin, Sleuth)
- Log monitoring (ELK Stack, Splunk)
- Health, Metrics Monitoring and Alerting (Actuator, Micrometer, Prometheus, Grafana)
- Extras: Distributed Messaging (Kafka, RabbitMQ), Distributes Caching (Redis)
- Transaction pattern: CQRS, Saga Pattern (Orchestration, Choreography)

## Database Selection
- SQL (MySQL, PostgreSQL, Oracle)
- NO-SQL
  - Key-Value (DynamoDB)
  - Document (MongoDB, DynamoDB)
  - Graph (Neo4j)
  - Column based (Cassandra, HBase)

| **Need/Situation**                          | **Recommended Database Type**     | **Examples**                         | **Description**                                                                                  |
|---------------------------------------------|-----------------------------------|--------------------------------------|--------------------------------------------------------------------------------------------------|
| **Structured Data with Relationships**      | Relational Database (SQL)         | MySQL, PostgreSQL, Oracle, SQL Server | Best for structured data with predefined schemas and complex relationships. Supports ACID transactions. |
| **Unstructured or Semi-structured Data**    | Document Store (NoSQL)            | MongoDB, Couchbase, Amazon DocumentDB | Ideal for storing JSON-like documents. Flexible schema allows easy updates to data structure.      |
| **High Write/Read Throughput & Scalability**| Wide-Column Store (NoSQL)         | Cassandra, HBase, ScyllaDB            | Suitable for large-scale data that requires high availability and horizontal scalability.         |
| **Real-time Analytics**                     | In-Memory Database                | Redis, Memcached, Aerospike           | Best for low-latency data access and real-time analytics. Stores data in memory for fast retrieval.|
| **Complex Queries and Analytics**           | Columnar Database                 | Amazon Redshift, Google BigQuery, Apache Parquet | Optimized for read-heavy workloads and complex queries, especially for data warehousing.           |
| **Graph Data with Complex Relationships**   | Graph Database                    | Neo4j, Amazon Neptune, ArangoDB       | Ideal for data with complex relationships, such as social networks or recommendation engines.      |
| **Time-Series Data**                        | Time-Series Database              | InfluxDB, TimescaleDB, Prometheus     | Optimized for storing and querying time-stamped data, like IoT or monitoring data.                 |
| **Data Replication & Global Distribution**  | Distributed Database              | CockroachDB, Google Spanner, Yugabyte | Best for applications needing strong consistency, global distribution, and multi-region replication.|
| **Simple Key-Value Data Access**            | Key-Value Store (NoSQL)           | Redis, DynamoDB, Riak                 | Efficient for simple lookups and when data access patterns are straightforward (key-value pairs).  |
| **File or Binary Data Storage**             | Object Storage                    | Amazon S3, Google Cloud Storage, MinIO| Best for storing large amounts of unstructured data like images, videos, and backups.              |


## CAP Theorem
- Consistency
- Availability
- Partition Tolerance


## Designing Systems
- Tiny URL
- Payment System
- Messaging App
- How to handle millions of http request

### How to handle millions of http request
- Load Balancing
- Horizontal Scaling
- Caching
- Graceful Degradation (Circuit breaker, Fallback, Retry)
- Asynchronous Messaging
- Reactive Processing
- Security (DDoS protection, Rate limiting, Web Application Firewall)
- Database/Query Optimization
- Code Optimization
- Load testing using Apache JMeter
- Monitoring and Alerting


### Refs:
- https://www.youtube.com/playlist?list=PLRtLu6rCuAlkO-HiER3AKoKkSG5DPp9TX
- https://www.youtube.com/playlist?list=PLBrWqg4Ny6vUJXmkQVRa3bRVB59y1dx5A    