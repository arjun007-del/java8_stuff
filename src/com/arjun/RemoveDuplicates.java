package com.arjun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RemoveDuplicates {

	public static void  main(String[] args) {
		
		ArrayList<Integer> integer = new ArrayList<>();
		System.out.println("Enter 5 integers :");
		try (Scanner input = new Scanner(System.in)) {
			for(int i=0;i<5;i++) {
				int temp = input.nextInt();
				
				if (!integer.contains(temp)) 
					integer.add(temp);
				
			}
		}
		
		Collections.sort(integer);
		System.out.println(integer);
	}
}
