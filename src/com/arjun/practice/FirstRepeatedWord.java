package com.arjun.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatedWord {

	public static void main(String[] args) {
		String text = "Hello world Java is the best programming language hello";
		
		//
		// first repeated word
		//
		String firstRepeatedWord = Arrays.stream(text.split(" "))
				.filter(new HashSet()::add)
				.findFirst()
				.orElse(null);
		System.out.println(firstRepeatedWord);

		/// first repeated char 
		// 1. counting char
		
	Map<Character, Long> countingChar =	text.chars().mapToObj(i ->(char)i)
		.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
	
	// 2. find out the first repeated char
	
	Optional<Character> firstRepeatedChar= countingChar.entrySet().stream()
	.filter(e -> e.getValue() > 1)
	.map(e -> e.getKey())
	.findFirst();
	
	Optional<Character> firstNonRepeatedChar= countingChar.entrySet().stream()
			.filter(entry -> entry.getValue() > 1)
			.map(entry -> entry.getKey())
			.findFirst();
	
	if (firstRepeatedChar.isPresent()) {
		System.out.println(firstRepeatedChar.get());
	}
	System.out.println(firstNonRepeatedChar.orElse(null));
		
	}
	  

}
