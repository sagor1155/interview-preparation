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
- For performance testing, I have used Apache JMeter (Test plan, Thread group, Sampler-Http Request, Listener), Check load time/latency 
- Maintained a `internal repository` which is a `private maven repository` (`Nexus` Repository) to host/manage shared libraries and also maintained versioning so that changing shared library code doesn't break other microservices.
- For deployment, I have used `Docker` to containerize each service and created `deplyment` and `service` configuration file for `Kubernetes`
- I also have experience in frontend development using `Angular` framework, specially building components, optimizing performance. 
- I mostly used `reactive approach` for all `asynchronous tasks` while developing `Angular` application using `RxJs`

**_US Client - FrontDoor_**
- Before the Netherlands client, I also have worked with a US client for around 8 months
- I have developed a couple of `AWS lambdas` for an `Amazon Connect` based contact center
- Along with lambdas, I have integrated `API Gateway`, `DynamoDB`, `SNS`, `SQS` and `S3`
- For building, development testing and deploying AWS resources I have used `serverless framework`. I used to configure resources into a `serverless.yml` file. 
- Collaborated with DevOps team for creating the `deployment pipelines` for `AWS Lambdas` using AWS Code Pipeline


## Tell me about a situation when you came up with an idea that impressed clients
**Situation:** 
- During the migration of a monolithic tax research platform to a microservice architecture at Kaz Software,  
A significant challenge we faced during this migration was handling `shared libraries`, 
which were deeply embedded (coupled) in the monolithic structure.

**Action:**
- To address this issue, I proposed creating a `centralized shared library repository`. 
- By leveraging Maven for dependency management, I developed a solution where all common functionalities, such as utility classes, and error handling mechanisms, 
were extracted into standalone libraries. 
- These libraries were then `versioned` and stored in a `Maven repository` (`Nexus Repository`), making them easily accessible to all microservices.
- Additionally, I introduced a CI/CD pipeline to automate the process of updating and deploying these shared libraries. 
This ensured that any changes made to the shared libraries were promptly propagated to all dependent microservices, maintaining consistency and reducing integration issues.

**Result:**
- The implementation of this shared library repository significantly streamlined the development process. 
- It eliminated redundancy, ensured consistency across microservices, and simplified maintenance. 
- The client was impressed with the efficiency, as it facilitated a smoother migration. 


## Tell about your experience related to AWS
- I have developed a couple of `AWS lambdas` for an `Amazon Connect` based contact center
- Along with lambdas, I have integrated `API Gateway`, `DynamoDB`, `SNS`, `SQS`, `S3`, `Step Function`, `Lex`, `CloudWatch Logs`
- Lambda invocation was done in several ways like from `Connect` instance, from `SNS` and from `API Gateway`
- For local development and testing of AWS Lambdas, I have used `serverless framework`. I used to configure resources into a `serverless.yml` file.

- Collaborated with DevOps team for creating the `deployment pipelines` for `AWS Lambdas` specially for setting the necessary environment variables.
- AWS Code Pipeline (Code Commit, Code Build, Code Deploy)
- I have experience of deploying application in ECS Cluster, EC2, Fargate


## How would you optimize performance of AWS Lambda
- Efficient code
- reduced bundle size
- provisioned concurrency
- lambda layers for shared dependency
- asynchronous data/request handling, non blocking

### Reduce Initialization Latency (Cold Start)
- Minimize Dependencies: Only include necessary libraries and packages in your deployment package. This reduces the size of the deployment package and speeds up the cold start.
- Provisioned Concurrency: Use provisioned concurrency to keep your function initialized and ready to handle requests.

### Optimize Code Execution
- Efficient Code: Write efficient and concise code. Avoid unnecessary computations and optimize algorithms.
- Asynchronous Processing: Use asynchronous operations to handle I/O-bound tasks like network requests.

### Use AWS Lambda Layers
- Shared Dependencies: Use Lambda layers to manage common dependencies. This helps in reducing the deployment package size and speeds up the initialization.
  Enable Function Caching
- Initialization Caching: Use global variables or static data that persist between invocations within the same execution environment. This reduces initialization time for frequently used data.

### Data Handling and Processing
- Efficient Data Access: Optimize access to data stores like DynamoDB or S3. Use appropriate read/write capacity units for DynamoDB and efficient S3 operations.


## STAR#1: Can you tell me about the most challenging project you have worked on?
Situation:
- In my last job, I worked on a client project which is a tax research platform. 
- The backend service for that application is a monolith in nature/architecture. 
- It was growing day by day, tightly coupled and takes more development time to add new feature and test. 
- Sometimes it involves testing the whole application even if we are changing only one module.

Action:
- I worked with the clients directly to research on how to split the monolith into multiple microservices. 
- Segregating the modules and converting it to a separate microservice was challenging because of the tight coupling. 
- Used spring cloud libraries to build the microservices. 
- Used Kafka and feign client for asynchronous and synchronous service-service communication.
- Adopted different transactional pattern - Saga pattern, CQRS Pattern
- Fault tolerance - Circuit Breaker Pattern, Retry, Bulkhead, Rate Limiting
- Used to maintain a `internal repository` which is a `private maven repository` (`Nexus` Repository) to host/manage shared libraries and also maintained versioning so that changing shared library code doesn't break other microservices 

Result:
- Because of the microservice architecture, the development and testing time was reduced, 
- It became more loosely coupled and developer can focus on only one service at a time.


## STAR#2: Tell me about a time you got stuck on a project and had to learn a new technology to complete it.
Situation:
- Working on microservice architecture was challenging for me.
- I had no prior experience on microservice architecture.

Action:
- Learned microservice architecture, spring cloud technologies, kubernetes over time
- I did/enrolled to an online course on Udemy to learn those technologies.
- Studied on my personal time also.
- Created prototype microservice project leveraging spring cloud technologies

Result:
- Quickly learned and adapted with the necessary technologies.
- Took approximately one month to learn.
- My team lead and client were happy with my progress.


**Another situation:**
 - Learning `Golang` for developing AWS Lambda while working with US Client


## STAR#3: Tell me about a time you saw a problem and took the initiative to fix it.
Situation:
- Frontend/Angular application was taking longer to load initially.
- Because all the modules were eagerly loaded which is unnecessary.  

Action:
- Reported to the client and created Jira task ticket for improvement.
- Changed module loading strategy to Lazy loading.
- Updated change detection strategy to on-push detection in many of the components.
- Maintained the component states to be immutable

Result:
- Reduced initial loading time.
- Initial loading time became 20% faster than before
- Change detection cycle takes less time to traverse whole component tree.


## STAR#4: Can you tell me what is your biggest professional accomplishment?
Situation:
- In my first job, I have worked on a Token Generation software.

Action:
- Developed token generation software using java for generating encrypted token
- These tokens were used for updating meter configuration and credit/billing parameters
- Developed this software following the client (BPDB)  provided interface and requirements
- This tool is the main integration point between client POS (point of sale) application and our energy meter.
- I have successfully developed and integrated this tool with client POS application

Result:
- This tool made the payment procedure easier, specially adding credits to smart energy meter.
- I got a bonus after the successful development and integration

## STAR#5: Tell me about a time when you helped your team.
Situation:
- Understanding the whole project was difficult as there was no proper documentation.
- Specially difficult for the new members to understand  different parts of the projects, scopes and how they are connected.

Action:
- Created short documents for existing services (available) and their responsibilities.
- Created diagrams for all connected parts. in `Confluence`
- Created API documentation
- Created documentation for necessary tools installation.

Result:
- All these things helped the team to understand different parts of the project
- Helped new team member to understand other parts/services related to the project.
- Made the onboarding process easier for new member.


## STAR#6: Tell me about a time when you made a mistake and how you solved it.
Situation:
- 

Action:
- 

Result:
- 	
