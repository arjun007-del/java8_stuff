package com.arjun;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeFilterWithJava8 {

	public static void main(String[] args) {
		 // Create a Map of employees
        Map<Integer, Employee> employees = new HashMap<>();
        employees.put(1, new Employee("John", "New York"));
        employees.put(2, new Employee("Jane", "California"));
        employees.put(3, new Employee("Bob", "New York"));
        employees.put(4, new Employee("Alice", "Texas"));
        
        // Filter employees by state using Java 8 features
        String state = "New York";
        Map<Integer, Employee> filteredEmployees = employees.entrySet().stream()
            .filter(entry -> state.equals(entry.getValue().getState()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        // Print out the filtered employees
        System.out.println("Employees in " + state + ":");
        filteredEmployees.forEach((id, employee) -> System.out.println(id + ": " + employee.getName()));

	}
	
	 static class Employee {
	        private String name;
	        private String state;
	        
	        public Employee(String name, String state) {
	            this.name = name;
	            this.state = state;
	        }
	        
	        public String getName() {
	            return name;
	        }
	        
	        public String getState() {
	            return state;
	        }
	    }

}
