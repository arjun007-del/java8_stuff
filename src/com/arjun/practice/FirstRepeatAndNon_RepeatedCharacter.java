package com.arjun.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatAndNon_RepeatedCharacter {

	public static void main(String[] args) {

		String input = "Hello world Java is the best programming language hello";

		// counting the character in a string using java8 feature

		Map<Character, Long> countingchar = input.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		// first repeated char in string
		
		Optional<Character> firstRepatedChar = countingchar.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.map(entry -> entry.getKey()).findFirst();

		// first Non repeated char in string
		Optional<Character> firstNonRepatedChar = countingchar.entrySet().stream()
				.filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey()).findFirst();

		if (firstNonRepatedChar.isPresent()) {
			System.out.println("first repeated char --> "+firstRepatedChar.get());

		}
		
		System.out.println("first Non repeated char --> "+firstNonRepatedChar.orElse(null));

	}

}
