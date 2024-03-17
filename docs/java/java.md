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

### When to use Comparable and Comparator
The decision to use Comparable or Comparator depends on the requirements and design of your application. Here are some guidelines:

- Use Comparable when the sorting logic is inherent to the object being sorted and does not change.
- Use Comparable for natural ordering and Comparator for custom or alternative ordering.
- Use Comparator when you want to define multiple sorting rules.
- Use Comparator to provide the sorting logic if Class doesn't implement Comparable

### Ref:
- https://medium.com/@himani.prasad016/comparable-vs-comparator-7aefb0a697c7
- https://www.youtube.com/watch?v=ZA2oNhtNk3w