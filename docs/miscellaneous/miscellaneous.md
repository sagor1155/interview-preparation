
## Miscellaneous Topics
- Tiny URL System Design
- Reverse Proxy, Forward Proxy
  - https://medium.com/javarevisited/what-is-reverse-and-forward-proxies-latest-2023-7d2f946c124b
- AWS Lambda: cold start time, shared library/code
- Java Completable Future
- Java volatile keyword
- GraphQL
- Elasticsearch
- MongoDB
- Cassandra 
- Oracle Database



### Java Volatile:
In Java, the `volatile` keyword is used to indicate that a variable's value may be modified by multiple threads that are executing concurrently. 
When a variable is declared as `volatile`, it ensures that any thread that reads the variable will see the most recently written value by any other thread. 
Essentially, it provides visibility guarantees across threads.

Unlike `synchronized` blocks or methods, the volatile keyword does not provide `atomicity` guarantees. 
It only ensures `visibility`. If multiple threads are writing to a volatile variable, it does not guarantee that the variable will be updated atomically.

Volatile is commonly used for flags or state variables that are accessed by multiple threads, 
especially in scenarios where one thread modifies the value and other threads need to react to that change.