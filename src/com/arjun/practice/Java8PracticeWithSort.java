package com.arjun.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8PracticeWithSort {

	public static void main(String[] args) {


		List<Employye> empList = new ArrayList<>();
		empList.add(new Employye("Arjun", 54, 40000));
		empList.add(new Employye("Suleman", 26, 50000));
		empList.add(new Employye("Sailu", 26, 60000));
		empList.add(new Employye("Satya", 59, 70000));
		empList.add(new Employye("Siva", 27, 80000));
		
		// storing list of object into map
//		Map<Double, List<Employye>> emplistBySalary =
//				empList.stream().collect(Collectors.groupingBy(Employye::getEmpSalary, Collectors.toList()));
//		
//		emplistBySalary.entrySet().forEach(entry -> {
//			System.out.println(entry.getValue());
//		});
		
		// sort the employee based on age descending order
		
		 empList.stream().sorted(Comparator.comparing(Employye::getEmpAge).reversed())
		 .forEach(emp -> System.out.println(emp.getEmpName()+"--"+emp.getEmpAge()+"--"+emp.getEmpSalary()));
		 
		 
		 /// using filter method get filterout the employee
		empList.stream().filter(emp -> emp.getEmpSalary() > 50000 && emp.getEmpAge() <30)
		.forEach(emp -> System.out.println(emp.getEmpName()));
		
		
		empList.stream().sorted(Comparator.comparing(Employye::getEmpSalary).reversed())
		.skip(1).findFirst().ifPresent(emp -> System.out.println(emp.getEmpSalary()));

	}

}

class Employye{
	
	private String empName;
	private int empAge;
	private double empSalary;
	
	
	
	public Employye(String empName, int empAge, double empSalary) {
		super();
		this.empName = empName;
		this.empAge = empAge;
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employye [empName=" + empName + ", empAge=" + empAge + ", empSalary=" + empSalary + "]";
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
}
