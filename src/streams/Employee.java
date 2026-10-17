package streams;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private int salary;
    private String department;
    public String getDepartment() {
        return department;
    }
    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(String name, int salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", salary=" + salary + ", department='" + department +'}';
    }

    public static void main(String[] args) {
       // Employee e1 = new Employee("Geeks", 10000);
        List<Employee> emp = Arrays.asList(new Employee("Geeks", 10000, "IT"),
                                            new Employee("Raj", 10000, "IT"),
                                            new Employee("Deep", 10000, "IT"),
                                            new Employee("Mon", 17000, "HR"),
                new Employee("Tue", 12000, "HR"),
                new Employee("Wed", 11000, "HR"),
                new Employee("Thu", 19000, "IT"     ));

        //maximum salary from a list of employees.
        Optional<Employee> max = emp.stream().max(Comparator.comparing(Employee::getSalary));

        System.out.println(max.get());

        //Find the second-highest salary.
        emp.stream().distinct().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(2).skip(1).forEach(System.out::println);
        System.out.println("---------------------------");
        System.out.println(emp.stream().distinct().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get());


        //sum of salaries of all employees.
        System.out.println(emp.stream().mapToInt(Employee::getSalary).sum());

        //highest salary in each department.
        Map<String, Optional<Employee>> highestByDept = emp.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        System.out.println(highestByDept);


        emp.stream().filter(e->e.getSalary()>10000).findFirst().ifPresent(System.out::println);


        //top 2 highest-paid employees
        emp.stream().distinct().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(2).forEach(System.out::println);

        //Sort employees by salary and then by name.
        System.out.println("Sort employees by salary and then by name.");
        emp.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).forEach(System.out::println);

       // Count the number of employees in each department.
        emp.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).forEach((k,v)->System.out.println(k+" : "+v));

        //find avg salary in each department
        System.out.println("find avg salary in each department");
        emp.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary))).forEach((k,v)->System.out.println(k+" : "+v));

        //maximum salary in each department
        System.out.println("maximum salary in each department");
        emp.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary)))).forEach((k,v)->System.out.println(k+" : "+v));


        //Convert all employee names into a comma-separated string.
        System.out.println("Convert all employee names into a comma-separated string.");
        System.out.println(emp.stream().map(Employee::getName).collect(Collectors.joining(",")));


        // Print all employee names using Parallel Stream.
        System.out.println("Print all employee names using Parallel Stream.");
        emp.parallelStream().map(Employee::getName).forEach(System.out::println);


        //Calculate the total salary of all employees as efficiently as possible using Streams.
        System.out.println("Calculate the total salary of all employees as efficiently as possible using Streams.");
        System.out.println(emp.parallelStream().mapToInt(Employee::getSalary).sum());

        // Find the total transaction amount for each category.
        System.out.println("Find the total transaction amount for each category.");
        Map<String, Long> categoryWiseTransaction = emp.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingLong(Employee::getSalary)));
        System.out.println(categoryWiseTransaction);


    }

}
