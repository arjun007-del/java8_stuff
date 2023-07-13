package com.arjun;

public class Test {

	public static void main(String[] args) {
		
		String input = "Hello Man How are you";
		
		String reverseString = "";
		
		for(int i = input.length() - 1; i >=0;i--) {
			reverseString += input.charAt(i);
		}
		
		System.out.println(reverseString);
		
//		StringBuilder reversestring = new StringBuilder(input).reverse();
//		System.out.println(reversestring.toString());
	}

}
