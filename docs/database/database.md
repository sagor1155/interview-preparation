# Database

## Normalization
- Database normalization is about organizing data in a database efficiently
- Database normalization is the process of restructuring an existing database schema to reduce redundancy and improve data integrity
- Normalization involves dividing a larger table into two or more tables and establishing relationships between these tables
- The objective is to isolate data in such a way that additions, deletions, and modifications can be made in one table and then propagated through the rest of the database via the defined relationships.
- Minimizes duplicate data, Prevents data inconsistencies, Simplifies queries, Enables flexible interface design, Improves scalability

### Denormalization
- Denormalization technique Focuses on improving the search performance.
- Merges two tables in order to reduce the number of joins to speed up query performance.

### First Normal Form (1NF)
- Every table must have primary key
- Every column must have atomic value
- Table must not have repeating groups

<img src="../images/1nf.png" alt="1NF"
style="float: left; margin-right: 10px; margin-bottom: 20px;"/>

### Second Normal Form (2NF)
- The data must be in First Normal Form (1NF)
- Remove partial dependency from the table
- All the non-key columns must be fully dependent on primary key, it should not be partially dependent

**Dependency ~ Functional Dependency:** All columns are dependent on only `one` primary key. 

**Partial Dependency:** Partial Dependency happens when there's two or more primary key exists in one table (Candidate Key) 

<img src="../images/2nf.png" alt="2NF"
style="float: left; margin-right: 10px; margin-bottom: 20px;"/>


### Third Normal Form (3NF)
- The data must be in First Normal Form (1NF) and Second Normal Form (2NF)
- Remove Transient/Transitive dependency from the table

**Transitive Dependency:** Happens when one column depends on another column which is not primary key.
Transitive dependency occurs when a non-key attribute depends on another non-key attribute. 

3NF ensures that each non-key attribute is directly dependent on the primary key.

<img src="../images/3nf.png" alt="3NF"
style="float: left; margin-right: 10px; margin-bottom: 20px;"/>


### Refs:
- https://www.youtube.com/watch?v=9hfjC-BpY20
- https://www.youtube.com/watch?v=9L10Q1nAfyg
- https://blog.det.life/understanding-database-normalization-from-basics-to-er-diagrams-488a53923cf4
- https://medium.com/@13032765d/database-normalization-the-key-to-efficient-data-storage-6c0f38d30765


## Primary Key, Foreign Key, Unique Key, Candidate Key
### Primary Key
- A column or a set of columns in a table that uniquely identifies each row.
- Must contain unique values
- `Cannot contain NULL` values 
- There can be `only one primary key` in a table.
- Every table should have a primary key to ensure data integrity and facilitate efficient querying.
- Primary key selection creates clustered index
- **Example:** The library catalog might designate a unique ID assigned to each book as the primary key for efficient retrieval and record keeping (this ID wouldn't be null).

### Foreign Key
- Creates a link between two tables. It references the primary key of another table.
- Can exist in multiple tables.
- Can be null (depending on the relationship type), but they must also exist as a value in the referenced primary key column.
- **Example:** In an Orders table, a customer_id foreign key column could link each order to a specific customer in the Customers table (referencing the customer_id primary key there).

### Unique Key
- Unique key ensures that all values in a column (or a set of columns) are unique. 
- `Can contain NULL` values, but `only one NULL value` is allowed per column. 
- A table can have `multiple unique keys`.
- Unique key selection creates non-clustered index
- **Example:** The ISBN number uniquely identifies a book (but it can be blank for some entries).

### Candidate Key
- A candidate key is a column or a set of columns that can uniquely identify each row in a table, similar to a primary key.
- `Can contain NULL` values
- A table can have multiple candidate keys.
- Candidate key does not necessarily have to be designated as the primary key of the table.
- **Example:** A combination of author name and book title could uniquely identify a book (but there might be multiple books by the same author).


