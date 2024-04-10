package org.example.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("D", 29, 90));
        emps.add(new Employee("C", 30, 120));
        emps.add(new Employee("A", 28, 95));
        emps.add(new Employee("B", 29, 110));
        emps.add(new Employee("B", 29, 105));
        emps.add(new Employee("A", 28, 85));

//        groupListWithUniqueValueSortedKeys(emps);
//        getStatistics(emps);
//        sliceArray(emps);
//        mapAndJoinString(emps);
        findDuplicateNames(emps);
        findRepeatingNames(emps);
    }
    private static void findRepeatingNames(List<Employee> emps) {
        Map<String, Long> grouped = emps.stream()
                .collect(Collectors.groupingBy(e -> e.name, Collectors.counting()));

        System.out.println("Grouped By Names: " + grouped);

        List<String> repeatingNames = grouped.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .toList();

        System.out.println("Repeating names: " + repeatingNames);
    }
    private static void findDuplicateNames(List<Employee> emps) {
        List<String> names = emps.stream().map(e -> e.name).toList();
        Set<String> uniqueNames = new HashSet<>();
        Set<String> duplicateNames = names.stream()
                .filter(n -> !uniqueNames.add(n))
                .collect(Collectors.toSet());

        System.out.println("Duplicate Names: " + duplicateNames);
        System.out.println("Unique Names: " + uniqueNames);
    }
    private static void mapAndJoinString(List<Employee> emps) {
        String names = emps.stream()
                .map(e -> e.name.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println("Joined Names: " + names);
    }
    private static void sliceArray(List<Employee> emps) {
        // find second and third youngest employee
        List<Integer> ages = emps.stream()
                .map(e -> e.age)
                .sorted()
                .distinct()
                .skip(1)
                .limit(2)
                .toList();

        System.out.println("Second and Third youngest employee: " + ages);
    }
    private static void getStatistics(List<Employee> emps) {
        IntSummaryStatistics salaryStat = emps.stream()
                .mapToInt(e -> e.salary)
                .summaryStatistics();

        System.out.println("max: " + salaryStat.getMax());
        System.out.println("min: " + salaryStat.getMin());
        System.out.println("cnt: " + salaryStat.getCount());
        System.out.println("Avg: " + salaryStat.getAverage());
    }
    private static void groupListWithUniqueValueSortedKeys(List<Employee> emps) {
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
    private static class Employee {
        public String name;
        public int age;
        public int salary;
        public Employee(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
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
                    ", salary=" + salary +
                    '}';
        }
    }

}
