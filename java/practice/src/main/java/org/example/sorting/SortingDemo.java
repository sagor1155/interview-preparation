package org.example.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person implements Comparable<Person> {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person that) {
        return this.age - that.getAge();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class PersonAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}

public class SortingDemo {
    public static void main(String[] args) {
//        testComparable();
        testComparator();
    }

    private static void testComparable() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John", 32));
        personList.add(new Person("Natasha", 29));
        personList.add(new Person("DSarker", 31));

        Collections.sort(personList);
        System.out.println(personList);
    }

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
}
