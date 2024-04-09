package org.example.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        groupListWithUniqueValueSortedKeys();
    }

    private static class Employee {
        public String name;
        public int age;
        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    private static void groupListWithUniqueValueSortedKeys() {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("D", 29));
        emps.add(new Employee("C", 30));
        emps.add(new Employee("A", 28));
        emps.add(new Employee("B", 29));
        emps.add(new Employee("A", 28));

        // grouping
        Map<Integer, List<Employee>> groupedMap = emps.stream()
                .collect(Collectors.groupingBy(emp -> emp.age));

        // grouping with unique value [MUST implement hashCode and equals in Employee class to use Set]
        Map<Integer, Set<Employee>> groupedUnique = emps.stream()
                .collect(Collectors.groupingBy(emp -> emp.age, Collectors.toSet()));

        // grouping with unique value with sorted keys
        Map<Integer, Set<Employee>> groupedUniqueSorted = emps.stream()
                .collect(Collectors.groupingBy(emp -> emp.age, TreeMap::new,  Collectors.toSet()));

        System.out.println(groupedMap);
        System.out.println(groupedUnique);
        System.out.println(groupedUniqueSorted);
    }
}
