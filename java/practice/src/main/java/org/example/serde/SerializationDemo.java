package org.example.serde;

import java.io.*;

class Employee implements Serializable {
    /*
     - sender and receiver must have the same SerialVersionUID
     - must be static, final and of type long
     - although it is static, it gets serialized too, so that at the object deserialization the sender and receiver can be verified
     */
    private static final long serialVersionUID = 21L;
    private final String name;
    private final int age;
    private final transient int salary; // 'static' and 'transient' don't take part in serialization
    private String company;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", company=" + company +
                '}';
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        performSerialization();
        performDeserialization();
    }

    private static void performSerialization() {
        Employee emp = new Employee("Mike", 29, 10000);
        String file = "./byte-stream.txt";

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(emp);
            System.out.println("Serialization: ");
            System.out.println(emp);
            fos.close();
            oos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void performDeserialization() {
        String file = "./byte-stream.txt";
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Employee emp = (Employee) ois.readObject();
            System.out.println("Deserialization: ");
            System.out.println(emp);
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
