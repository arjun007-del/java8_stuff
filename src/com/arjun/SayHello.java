package com.arjun;

public class SayHello {

	public static void main(String[] args) {
//		System.out.println("Hello !!!!!!!!!!!!");
		
		String str= "test";
		String rev="";
		
		for(int i = str.length()-1;i>=0;i--) {
			rev = rev+str.charAt(i);
			
		}
		System.out.printf("rev String: "+rev);

	}

}
