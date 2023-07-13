package com.arjun.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewPractice {

	public static void main(String[] args) {
		
//	1. print the second highest integer in arr
		
		int[] arr = {1,2,4,9,5,7};
		
		int secondhighestint = Arrays.stream(arr)
				.distinct() // using this method removing the duplicates
				.boxed() // converting int to Integer
				.sorted((a,b) -> b - a) // using this method sort the int descending order
				.skip(1)
				.findFirst()
				.orElse(1);
		System.out.println(secondhighestint);
				
///  2. first repeated word in a string 
		
		String input = "Hello folks this is my Hello program";
		
		String firstRepeatword = 
				Arrays.stream(input.split(" ")) // convert string to stream and split the each word
				.filter(new HashSet<String>()::add) // storing the HashSet class it won't allow duplicates
				.findFirst()
				.orElse(null);
		System.out.println("firstRepeatword "+firstRepeatword);
		
//		3. print the first Repeated character in string
		
	  Map<Character, Long> countingchar =input.chars()  // returns IntStream of unicode code points each char in the string
		.mapToObj(i -> (char)i) // this method converts each integer into IntStream
		.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new
				,Collectors.counting()));
	  
	  
	 Optional<Character> firstRepeatedChar = countingchar.entrySet().stream()
	  .filter(entry -> entry.getValue() > 1) // filter the each entry repeated or not
	  .map(entry -> entry.getKey()) // create new object when repeated char
	  .findFirst();
	 System.out.println(firstRepeatedChar);
	 
	 
//	 4. print the second highest salary
	 
	 List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101, "Malli", 101, "active",2000));
		empList.add(new Employee(102, "suleman", 101, "active",5000));
		empList.add(new Employee(103, "ashok", 102, "Inactive",7000));
		empList.add(new Employee(104, "rohit", 102, "active",6000));
		empList.add(new Employee(105, "sai", 103, "Inactive",56000));
		empList.add(new Employee(106, "sailu", 103, "active",6000));
		empList.add(new Employee(107, "lakshmi", 104, "active",8000));
		
		
		Optional<Employee> secondhighsal= empList.stream()
		.sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1)
		.findFirst();
		
		System.out.println("secondhighsal --> "+secondhighsal);
	  
//   5. print the emp based dept
		
		Map<Integer, List<Employee>> empListDept= empList.stream()
				.collect(Collectors.groupingBy(Employee::getEmpDept,Collectors.toList()));
		
		empListDept.entrySet().forEach(entry ->{
			System.out.println(entry.getKey()+" -->"+entry.getValue());
		});
	}

}

