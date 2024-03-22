# Java Fundamentals
- [ ] Memory management
- [ ] Reactive
- [ ] Collection API
- [ ] Threading
- [ ] Exceptions
- [ ] Comparator vs Comparable
- [ ] Optional
- [ ] Stream API
- [ ] Unit Testing
- [ ] Java Feature Changes


## Collection API

### Refs
- 

## Threading 
- Threading Basics
- Creating Threads 
- Race Condition and Synchronization
- Thread Lifecycle/States
- Types of Threads (User, Daemon)
- Useful methods
- 

### Refs
- https://tipsontech.medium.com/multi-threading-in-java-b33620ce7b0a
- Telusko videos: (85-90)
  - https://www.youtube.com/watch?v=KuvkahVyY9E
  - https://www.youtube.com/watch?v=UfMM924sBvg
  - https://www.youtube.com/watch?v=yyLy-an_CXY
  - https://www.youtube.com/watch?v=Z4KSgLpY0d8
  - https://www.youtube.com/watch?v=7eV4nib3Cm8
  - https://www.youtube.com/watch?v=IWll7sfz3g0
  - 

## Comparator vs Comparable

### Comparable
```java
public interface Comparable<T> {
    public int compareTo(T o);
}
```

```java
class Person implements Comparable<Person> {
    private String name;
    private Integer age;

    @Override
    public int compareTo(Person that) {
        return this.age - that.getAge();
    }
}
```

```java
private static void testComparable() {
    List<Person> personList = new ArrayList<>();
    personList.add(new Person("John", 32));
    personList.add(new Person("Natasha", 29));
    personList.add(new Person("DSarker", 31));

    Collections.sort(personList);
    System.out.println(personList);
}
```

Result
```
[Person{name='Natasha', age=29}, Person{name='DSarker', age=31}, Person{name='John', age=32}]
```

### Comparator
```java
@FunctionalInterface
public interface Comparator<T> {
    ...
    int compare(T o1, T o2);
    ...
}
```

```java
class PersonAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}

```

```java
private static void testComparator() {
    Comparator<Person> personNameLengthComparator = (p1, p2) -> {
        return p1.getName().length() - p2.getName().length();
    };

    List<Person> personList = new ArrayList<>();
    personList.add(new Person("John", 32));
    personList.add(new Person("Natasha", 29));
    personList.add(new Person("DSarker", 31));

    Collections.sort(personList, new PersonAgeComparator());
    System.out.println(personList);

    Collections.sort(personList, personNameLengthComparator);
    System.out.println(personList);

    Collections.sort(personList, (p1, p2) -> p1.getName().compareTo(p2.getName()));
    System.out.println(personList);
}
```

Result
```
[Person{name='Natasha', age=29}, Person{name='DSarker', age=31}, Person{name='John', age=32}]
[Person{name='John', age=32}, Person{name='Natasha', age=29}, Person{name='DSarker', age=31}]
[Person{name='DSarker', age=31}, Person{name='John', age=32}, Person{name='Natasha', age=29}]
```

### When to use Comparable and Comparator
The decision to use Comparable or Comparator depends on the requirements and design of your application. Here are some guidelines:

- Use Comparable when the sorting logic is inherent to the object being sorted and does not change.
- Use Comparable for natural ordering and Comparator for custom or alternative ordering.
- Use Comparator when you want to define multiple sorting rules.
- Use Comparator to provide the sorting logic if Class doesn't implement Comparable

### Refs
- https://medium.com/@himani.prasad016/comparable-vs-comparator-7aefb0a697c7
- https://www.youtube.com/watch?v=ZA2oNhtNk3w


## Exceptions
### Error 
Errors in a program are non-recoverable. Program gets terminated in case of error occurence.
Error can happen because of lack of system resources such as heap memory is not available etc. 
During the runtime of a program if any error occurs we will not be able to handle it.
Examples: `OutOfMemoryError`, `StackOverflowError`, 

### Exception
Exceptions are recoverable by handling them properly. 
Example: trying to access a property from a null object - `NullPointerException`,
dividing an interger by zero - `ArithmaticException` etc. 

### Exception Hierarchy
<img src="../images/java-exception.webp"
     alt="Java Exception Hierarchy"
     style="float: left; margin-right: 10px; margin-bottom: 20px;" />

### Exception Types
- Checked
- Unchecked

#### Checked Exception
- All exceptions other than `RuntimeException` and `Error` are known as `Checked` exception
- These exceptions are checked by the compiler at compile time itself
- E.g. For file read operation compiler forces us to handle `FileNotFoundException` because it's possible that the file is not present
- Some other checked exceptions are `SQLException`, `IOException` etc. 

#### Unchecked Exception
- Runtime Exceptions are known as `Unchecked` exceptions. 
- Compiler doesn't force us to handle these exception but as a programmer it is our responsibility to handle runtime exceptions
- E.g. `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundException` etc.


### Class Cascade Exception


### Finally vs Return
- Finally block gets executed even though return statement is available inside try block. 
- Finally block gets more priority than the return statement. 
- In case all try, catch, finally block return some value, then finally block return takes priority.

### Finally Vs System.exit(0)
- JVM gets exited when `System.exit(0)` code executes. 
- If we use `System.exit(0)` inside try block, then finally block will not execute. 

### throw vs throws
**`throw`**
- used to explicitly throw an exception
- throw keyword is followed by an instance of an exception
- you can throw one exception at a time
- using throw keyword only unchecked exceptions are propagated

**`throws`**
- used with the method signature to declare an exception which might get thrown by the method while executing the code 
- throws is followed by exception class names
- you can declare multiple exceptions using throws keyword
- using throws keyword both checked and unchecked exceptions can be propagated
- used for ducking exception

### Refs
- https://interviewnoodle.com/exception-in-java-89a0b41e0c45
- 