
## Miscellaneous Topics
- Tiny URL System Design
- Reverse Proxy, Forward Proxy
  - https://medium.com/javarevisited/what-is-reverse-and-forward-proxies-latest-2023-7d2f946c124b
- AWS Lambda: cold start time, shared library/code
- Java Completable Future
- Java volatile keyword
- GraphQL
- Elasticsearch
- PostGreSQL
- MongoDB
- Cassandra
- Oracle Database
- ELK Stack
- How to load multiple module/component on bootstrap in angular
- Short circuit operation/evaluation in java stream
- 12 Factor App
- Jenkins
- SAGA pattern
- Hibernate core concepts
- Hibernate life cycle
- Middleware in Java
- J2EE architecture and frameworks
- Kafka: maintain order for multiple partitions
- REST API Principles
- Explain different kind of mocking object (testing)
- Prometheus, Grafana, and JVisualVM
- Database scaling, Sharding


## Job Description/Recuirements:
- We are looking for Engineers who can 
- Write applications in Java using Object Oriented Design Principles
- Create Java Spring Boot REST Services
- Use Java Streams API to work with real time data
- Create a Java Thread Executor Pool to read & write from a Thread-safe queue
- Use Java Lambdas for use in Collections
- Create Distributed Cloud Configuration with Spring Cloud 
- Create Circuit Breakers with Spring Cloud
- Create a Database Integration via Hibernate or Spring Data
- Optimize business logic & SQL queries to enhance performance by 50+%
- Setup Kafka to support 10mm messages / hr throughput on 2KB payloads
- Deploy a Kafka Multi-AZ Cluster on AWS
- Build Services that are Highly Available (Multi-AZ & Multi-Region)
- Build Algorithms to Optimize Execution times and reduce end to end latency
- Use & Tweak Terraform Scripts to deploy Kubernetes Clusters with EKS
- Navigate & debug Java Apps on a Linux EC2 Instance


## Stored Procedures vs Dynamic SQL
| Feature                | Stored Procedures                                | Dynamic SQL                                      |
|------------------------|--------------------------------------------------|--------------------------------------------------|
| **Performance**        | Precompiled and cached, leading to faster execution. | Compiled at runtime, leading to potential overhead. |
| **Flexibility**        | Less flexible; designed for predefined operations. | Highly flexible; allows query construction at runtime. |
| **Security**           | Provides better security through encapsulation and parameterization. | More prone to SQL injection if not properly parameterized. |
| **Access Control**     | Can restrict direct table access and enforce business rules. | Requires careful permission management for direct table access. |
| **Maintainability**    | Centralizes business logic in the database, making it easier to manage. | Business logic can be scattered across application code, making it harder to maintain. |
| **Reusability**        | High reusability across different applications. | Limited reusability, tied to specific application logic. |
| **Complex Search Queries**| Less suited for scenarios requiring highly variable search criteria. | Well-suited for complex search functionality and ad hoc queries. |
| **Caching**            | Supports query caching for improved performance. | Does not inherently support query caching. |
