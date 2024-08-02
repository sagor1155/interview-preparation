# PostgreSQL

- Object Relational Database Management System (ORDBMS)
- Multi-Version Concurrency Control (MVCC)
- Rich set of advanced data types
- Custom Object Creation
- JSON Query Support
- Write heavy operation and complex queries
- High SQL Standard Compliance


## Server Architecture

## JSON Query Handling

## Concurrency Support
Concurrency is handled using: 
- Multi-Version Concurrency Control (MVCC)
- locking mechanisms (LOCK)
- Isolation levels
- Optimistic and Pessimistic locking.

## Multi-Version Concurrency Control (MVCC)
Multi-Version Concurrency Control (MVCC) in PostgreSQL is a method used to handle concurrent transactions 
and ensure data consistency without the need for locking mechanisms that can degrade performance. 

### Here's how MVCC works in PostgreSQL

#### Data Versions: 
Each row in a PostgreSQL table can have multiple versions, where each version represents the state of the data at a particular point in time. 
These versions are created by transactions that insert, update, or delete rows.

#### Transaction IDs: 
Every transaction is assigned a unique transaction ID (XID). When a transaction modifies a row, the old version of the row is not 
immediately deleted. Instead, a new version of the row is created with the transaction ID of the modifying transaction.

#### Visibility Rules: 
When a query is executed, PostgreSQL determines which version of each row should be visible to the query based on the transaction IDs. 
This is done using the following rules:
- A version of a row is visible to a transaction if it was created by a transaction that committed before the current transaction started.
- A version is not visible if it was created by a transaction that started after the current transaction.
- Deleted rows are treated similarly, where the deletion is visible only if it was done by a transaction that committed before the current transaction started. 

#### No Locks for Reads: 
Because each transaction sees a consistent snapshot of the data as of the start of the transaction, 
readers do not block writers and writers do not block readers. This improves performance and concurrency.

#### Cleanup (Vacuuming): 
Over time, old versions of rows that are no longer visible to any active transaction need to be cleaned up 
to reclaim storage space. PostgreSQL uses a process called VACUUM to remove these obsolete versions.

### Advantages of MVCC
- **Improved Concurrency:** By allowing multiple versions of data to exist, MVCC enables high concurrency without locking.
- **Consistent Reads:** Each transaction sees a consistent snapshot of the database, which simplifies application logic and ensures data integrity.
- **Non-Blocking Reads:** Queries can read data without being blocked by other transactions that are writing to the same data.


### Example Scenario
Consider a table with a row that initially contains value = 10. If transaction T1 updates this row to value = 20 and transaction T2 updates it to value = 30:

- When T1 starts, it creates a new version of the row with value = 20 and a new transaction ID.
- When T2 starts, it creates another new version with value = 30 and a different transaction ID.
- If a third transaction T3 starts after T1 has committed but before T2 has committed, T3 will see value = 20 because it will ignore the version created by T2, which has not yet committed.

This ensures that each transaction works with a consistent view of the data, improving both the performance and reliability of the database.

## EXPLAIN command
The `EXPLAIN` command is used to analyze and display the execution plan of a SQL query, 
showing how PostgreSQL will execute the query and the cost associated with each step.

## MySQL vs PostgreSQL

| Feature/Aspect                | MySQL                                      | PostgreSQL                                                      |
|-------------------------------|--------------------------------------------|-----------------------------------------------------------------|
| **General Overview**          | Popular, widely used open-source RDBMS     | Advanced, open-source ORDBMS                                    |
| **SQL Standard Compliance**   | Partial                                    | High                                                            |
| **ACID Compliance**           | Yes, with InnoDB storage engine            | Yes                                                             |
| **Data Types**                | Limited, basic data types                  | Rich set of advanced data types                                 |
| **Custom Object Create**      | No (Allows Enum, Set etc)                  | Yes                                                             |
| **Stored Procedures and Functions** | Yes                                        | Yes, with more advanced capabilities                            |
| **JSON Support**              | Yes, with JSON and JSONB types             | Yes, with JSON type                                             |
| **Indexing**                  | B-tree, Full-text, Hash (InnoDB only)      | B-tree, Hash, GiST, SP-GiST, GIN, BRIN                          |
| **Full-Text Search**          | Yes (InnoDB and MyISAM)                    | Yes, advanced full-text search                                  |
| **Partitioning**              | Yes                                        | Yes                                                             |
| **Concurrency Control**       | MVCC (with InnoDB)                         | MVCC (Multi-Version Concurrency Control)                        |
| **Performance**               | Generally faster for read-heavy operations | Generally better for complex queries and write-heavy operations |
| **JSONB Indexes**             | No                                         | Yes                                                             |
| **Materialized Views**        | No                                         | Yes                                                             |
| **Transactions**              | Yes (with InnoDB)                          | Yes                                                             |
| **Triggers**                  | Yes                                        | Yes                                                             |


