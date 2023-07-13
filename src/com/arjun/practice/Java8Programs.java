package com.arjun.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Programs {

	public static void main(String[] args) {
		
		
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101, "Malli", 101, "active",2000));
		empList.add(new Employee(102, "suleman", 101, "active",5000));
		empList.add(new Employee(103, "ashok", 102, "Inactive",7000));
		empList.add(new Employee(104, "rohit", 102, "active",6000));
		empList.add(new Employee(105, "sai", 103, "Inactive",56000));
		empList.add(new Employee(106, "prasanna", 103, "active",6000));
		empList.add(new Employee(107, "lakshmi", 104, "active",8000));
		
		// 1. to print the emp details based on dept -------->
		
		Map<Integer,List<Employee>> emplistBasedOnDept= 
				empList.stream().collect(Collectors.groupingBy(Employee::getEmpDept, Collectors.toList()));
		
		emplistBasedOnDept.entrySet().forEach(entry -> {
			System.out.println(entry.getKey()+ "------"+ entry.getValue());
		});
		
		// 2. to print the emp count working in each dept  ---------------->
		
		Map<Integer, Long>  empcountBasedOnDept =
				empList.stream().collect(Collectors.groupingBy(Employee::getEmpDept,Collectors.counting()));

		empcountBasedOnDept.entrySet().forEach(entry -> {
			System.out.println("Dept "+entry.getKey()+"----"+ entry.getValue());
		});
		
		
		// 3. to print the active and inactive emp count ---------------->
		
		long activeEmpCount = empList.stream().filter(e -> "active".equals(e.getStatus())).count();
		long InActiveEmpCount = empList.stream().filter(e -> "Inactive".equals(e.getStatus())).count();
		
		System.out.println("active emp count"+ activeEmpCount);
		System.out.println("Inactive emp count"+ InActiveEmpCount);
		
		// 4. to print the min and max salary of employee ---------------->
		
		Optional<Employee> maxEmp= empList.stream().max(Comparator.comparing(Employee::getSalary));
		Optional<Employee> minEmp = empList.stream().min(Comparator.comparing(Employee::getSalary));
		
		System.out.println("Max emp Salry"+ maxEmp);
		System.out.println("Min emp Salary"+ minEmp);
		
		// 5. to print the emp max salary based on dept ---------------->
		
		Map<Integer, Optional<Employee>> maxSalarybaseddpt= empList.stream().collect(Collectors.groupingBy(Employee::getEmpDept,
				Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))
				));
		
		maxSalarybaseddpt.entrySet().forEach(entry ->
		System.out.println("Dept "+ entry.getKey()+"top emp"+entry.getValue())
				);
		
		// 6. print the second highest salary from the emp list
		
		empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1)
		      .findFirst().ifPresent(emp -> System.out.println(emp));
		
		
		//7 Fibonacci series
		 
		int fibCount =10;
		Stream.iterate(new int[] {0,1}, fib -> new int[] {fib[1],fib[0] + fib[1]})
			.limit(fibCount)
			.forEach(fib -> System.out.print(fib[0]+" "));
	}

}
