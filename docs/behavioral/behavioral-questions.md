# Behavioral Questions

## Questions:
- SPS / Tell me about yourself (introduce)
- Tell me about the last project you worked on or, experience in last company
- Most challenging project/task
- Tell me about a time you got stuck and had to learn new technology
- Tell about a time you saw a problem and took initiative to fix it
- Can you tell me what is your biggest professional accomplishment
- Tell me about a time when you helped your team.
- Tell me about a time when client changed the requirements? How did you handle this?
- Did you ever have a teammate that wasn’t doing their job properly? What did you do?
- How to resolve co-worker conflict?


## Short Professional Statement (SPS) / Tell me about yourself (introduce)
- I’m a self-motivated software engineer with 7 and half years of experience developing web applications using multiple different technologies.
- I have developed applications for different domains like Tax Research Platform, Healthcare, Energy Sector and IoT.
- Developed enterprise applications using cutting edge technologies like Java, Spring Boot, Spring Cloud, Microservices and Angular. (Docker, Kubernetes, AWS)
- I have experience of working with clients from different countries.
- I can quickly adapt to new technologies.
- I love to take the ownership of the product I’m working on.
- I believe, I will be a valuable resource to your company. 
- I’m excited about this opportunity because it’s aligned with my professional experience.


## Tell me about the last project you worked on or, experience in last company
**_Netherlands clients - IBFD_**
- In my last job, I worked on a client project which is a tax research platform. The backend service for that application was a monolith spring boot project.
- I worked with the clients directly to research on how to split the monolith into multiple microservices. 
- Most challenging part was to reduce the coupling between multiple modules and splitting it up into separate services
- I have used `spring cloud` libraries to build the microservices. Some of the spring cloud components are: 
  - API gateway (Zuul)
  - Configuration service
  - Registry service (Eureka Discovery Service)
  - Load balancer (Ribbon)
  - Fault tolerance (Hystrix, Resilience4j, Circuit breaker pattern)
  - Distributed tracing (Zipkin, Sleuth)
  - Log monitoring (ELK Stack, Splunk)
  - Health, Metrics Monitoring and Alerting (Actuator, Micrometer, Prometheus, Grafana) 
  - Extras: Distributed Messaging (Kafka, RabbitMQ), Distributes Caching (Redis)

- Built a separate `auth service` for ensuring authentication and authorization
- Implemented both synchronous and asynchronous communication between services using `Feign client` and `Kafka`
- Mostly used functional style programming using Streams API
- For testing, I have used `JUnit` and `Mockito` framework
- For deployment, I have used `Docker` to containerize each service and created `deplyment` and `service` configuration file for `Kubernetes`
- I also have experience in frontend development using `Angular` framework, specially building components, optimizing performance. 
- I mostly used `reactive approach` for all `asynchronous tasks` while developing `Angular` application using `RxJs`

**_US Client - FrontDoor_**
- Before the Netherlands client, I also have worked with a US client for around 8 months
- I have developed a couple of `AWS lambdas` for an `Amazon Connect` based contact center
- Along with lambdas, I have integrated `API Gateway`, `DynamoDB`, `SNS`, `SQS` and `S3`
- For building, development testing and deploying AWS resources I have used `serverless framework`. I used to configure resources into a `serverless.yml` file. 
- Collaborated with DevOps team to create the `deployment pipelines` in `AWS environment`
