package com.arjun.practice;

import java.util.Arrays;

public class SecondHighestInteger {

	public static void main(String[] args) {
		
		int[] arr = {};
		
		int secondhighest = Arrays.stream(arr)
				.distinct()
				.boxed()
				.sorted((a,b)-> b - a)
				.skip(1)
				.findFirst()
				.orElse(1);
		System.out.println(secondhighest);

	}

}
