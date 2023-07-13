package com.arjun.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class PrintSecondHighestValue {

	
	public static void main(String[] args) {
		
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101, "Malli", 101, "active",2000));
		empList.add(new Employee(102, "suleman", 101, "active",5000));
		empList.add(new Employee(103, "ashok", 102, "inactive",7000));
		empList.add(new Employee(104, "rohit", 102, "active",6000));
		empList.add(new Employee(105, "sai", 103, "inactive",56000));
		empList.add(new Employee(106, "prasanna", 103, "active",6000));
		empList.add(new Employee(107, "lakshmi", 104, "active",8000));
		
		/// to print second highest salary
		
		empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
		.skip(1).findFirst().ifPresent(s -> System.out.println(s));
		
		// to print employee details  each department
		
		Map<Integer, List<Employee>> empdetailsdpt= empList.stream().collect(Collectors.groupingBy(Employee::getEmpDept, Collectors.toList()));

		empdetailsdpt.entrySet().forEach(entry ->{
			System.out.println("Dept"+entry.getKey()+"------"+entry.getValue());
		});
		
		
		// print the employee count each dept
		
		Map<Integer, Long> empCount= empList.stream().collect(Collectors.groupingBy(Employee::getEmpDept,Collectors.counting()));
		
		empCount.entrySet().forEach(entry ->{
			System.out.println("Dept"+entry.getKey()+"-------"+entry.getValue());
		});
		
		// print the active and inactive employees in given list
		
		long empcount1 = empList.stream().filter(e -> "active".equals(e.getStatus())).count();
		long empcount2= empList.stream().filter(e -> "inactive".equals(e.getStatus())).count();
		System.out.println("active emp ----- "+empcount1);
		System.out.println("inactive emp ---- "+empcount2);
		
		
		
	/// print the max and min salary emp
		
	   Optional<Employee> maxemp =	 empList.stream().max(Comparator.comparing(Employee::getSalary));
	   Optional<Employee> minemp = empList.stream().min(Comparator.comparing(Employee::getSalary));
	   
	   System.out.println("max salary emp"+ maxemp);
	   System.out.println("max salary emp"+ minemp);
	   
	   // print the max  salary of emp each dept
	   
	  Map<Integer, Optional<Employee>> maxSalaryEachDpt = empList.stream().collect(Collectors.groupingBy(Employee::getEmpDept,
			   Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))
			   ));
	  
	  maxSalaryEachDpt.entrySet().forEach(entry ->{
		  System.out.println("Dept"+entry.getKey()+"max salary"+entry.getValue());
	  });
	}
	

}

