
## Miscellaneous Topics
- Tiny URL System Design
- Reverse Proxy, Forward Proxy
  - https://medium.com/javarevisited/what-is-reverse-and-forward-proxies-latest-2023-7d2f946c124b
- GraphQL
- Elasticsearch
- MongoDB
- Cassandra
- Oracle Database
- ELK Stack
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
- Prometheus, Grafana
- VisualJVM
- Database scaling, Sharding


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
