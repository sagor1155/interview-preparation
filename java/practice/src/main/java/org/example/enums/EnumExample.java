package org.example.enums;

enum Color {
    RED, GREEN, BLUE, BLACK;

    private Color() { // always private, can't be instantiated, called for every enum constant
        System.out.println("Constructor Called For: " + this.toString());
    }
}

enum EmployeeEnum {
    MIKE(28), JOHN(29), LISA(27);

    private int age;

    private EmployeeEnum(int age) {
        this.age = age;
        System.out.println("Constructor called for: " + this.toString());
    }

    public int getAge() {
        return age;
    }
}

public class EnumExample {
    public static void main(String[] args) {
        for (Color c: Color.values()) { // values() returns array of all constants
            System.out.print(c.ordinal() + ": "); // ordinal() returns the index of constant
            System.out.println(Color.valueOf(c.name())); // valueOf() returns value of given constant
        }

        System.out.println("Age of LISA is " + EmployeeEnum.LISA.getAge());
    }
}
