# SOLID Principle
The SOLID principles are a set of design principles in object-oriented programming 
intended to make software designs more understandable, flexible, and maintainable.

- Single Responsibility Principle (SRP)
- Open-Close Principle (OCP)
- Liskov Substitution Principle (LSP)
- Interface Segregation Principle (ISP)
- Dependency Inversion Principle (DIP)

## Single Responsibility Principle (SRP)
A class should have only one reason to change, meaning that it should have only one responsibility.

```java
class Book {
    private String title;
    private String author;
    
    // constructors, getters, setters
    
    // Methods related to book's content
    public String getContent() {
        // code to fetch content from a source
        return "Content of the book";
    }

    // Methods related to book's printing
    public void printBook() {
        // code to print the book
    }
}
```

In this example, the Book class has two responsibilities: managing the book's content and printing the book. It violates the SRP. 
To adhere to SRP, we should separate these responsibilities into two different classes.

## Open-Close Principle (OCP)
Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.

```java
interface Shape {
    double area();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.area();
    }
}
```

In this example, the AreaCalculator class is closed for modification 
because it doesn't need to change when new shapes are added (it is open for extension). 
We can add new shapes (like Triangle) without modifying the AreaCalculator class.

## Liskov Substitution Principle (LSP)
Objects of a superclass shall be replaceable with objects of its subclasses without breaking the application.

```java
class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Duck extends Bird {
    // Duck can fly
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich cannot fly");
    }
}

public class Main {
    public static void main(String[] args) {
        Bird duck = new Duck();
        Bird ostrich = new Ostrich();

        duck.fly();    // Output: Bird is flying
        ostrich.fly(); // Throws UnsupportedOperationException
    }
}
```

When we try to call the fly() method on an Ostrich object, 
it throws an UnsupportedOperationException, violating the Liskov Substitution Principle. 
This means that substituting an Ostrich for a Bird affects the correctness of the program, 
as it behaves differently from other subclasses of Bird.

## Interface Segregation Principle (ISP)
Clients should not be forced to implement interfaces they don't use.

```java
interface Document {
    void print();
    void fax();
}

class Printer implements Document {
    @Override
    public void print() {
        // Print implementation
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException("Printer cannot fax");
    }
}

class FaxMachine implements Document {
    @Override
    public void print() {
        throw new UnsupportedOperationException("Fax machine cannot print");
    }

    @Override
    public void fax() {
        // Fax implementation
    }
}
```

In this example, `Printer` and `FaxMachine` classes implement the `Document` interface. However, `Printer` cannot perform faxing, and `FaxMachine` cannot print. 
According to ISP, we should split the `Document` interface into separate interfaces for printing and faxing to avoid forcing clients to implement methods they don't use.

## Dependency Inversion Principle (DIP)
- High level class must not depend upon a lower level class.
- Abstraction: High level class should depend on the interface
- Dependency Injection Pattern: Dependency of lower level class should be injected from outside

```java
public class DataAccessLayer {
    public void addCustomer(String name) {
        FileLogger logger = new FileLogger();
        logger.log("Customer added: " + name);
    }
}
```

Here, `DataAccessLayer` directly depends on `FileLogger` but it should not according to DIP. 
Instead, we should depend on the interface and inject the dependency from outside.

```java
public interface Logger {
    void log(String message);
}

public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        // log to file
    }
}

public class DataBaseLogger implements Logger {
    @Override
    public void log(String message) {
        // log to database
    }
}

public class DataAccessLayer {
    // depends on Logger interface
    private Logger logger;
    
    // dependency injection through constructor
    public DataAccessLayer(Logger logger) {
        this.logger = logger;
    }
    
    public void addCustomer(String name) {
        logger.log("Customer added: " + name);
    }
}
```

