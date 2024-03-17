# Java Fundamentals
- [ ] Java Feature Changes
- [ ] Memory management
- [ ] Reactive
- [ ] Collection API
- [ ] Threading
- [ ] Exceptions
- [ ] Comparator vs Comparable
- [ ] Stream API

## Collection API

### Ref:
- 

## Threading 
- Threading Basics
- Creating Threads 
- Race Condition and Synchronization
- Thread Lifecycle/States
- Types of Threads (User, Daemon)
- Useful methods
- 

### Ref: 
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

### Ref:
- https://medium.com/@himani.prasad016/comparable-vs-comparator-7aefb0a697c7
- https://www.youtube.com/watch?v=ZA2oNhtNk3w