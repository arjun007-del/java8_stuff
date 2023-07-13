package com.arjun.practice;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Employeee> employeeList = new ArrayList<>();
        employeeList.add(new Employeee("Alice", 55000, 25));
        employeeList.add(new Employeee("Bob", 70000, 35));
        employeeList.add(new Employeee("Charlie", 40000, 28));
        employeeList.add(new Employeee("Dave", 60000, 22));

        employeeList.stream()
                .filter(employee -> employee.getSalary() > 50000 && employee.getAge() < 30)
                .forEach(employee -> System.out.println(employee.getName()));
    }
}

class Employeee {
    private String name;
    private int salary;
    private int age;

    public Employeee(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}

