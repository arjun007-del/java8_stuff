package com.arjun;

import java.util.regex.Pattern;

public class Test4 {
	
	public static void main(String[] args) {
		
		System.out.println(Pattern.matches("^[^\\d]*", "123abc"));
		System.out.println(Pattern.matches("^[^\\d]*", "abc123"));
		System.out.println(Pattern.matches("(^[^\\d]*)(\\d)", "123abcxyz"));
		System.out.println(Pattern.matches("(^[^\\d]*)(\\d)", "abc123xyz"));
	}

}
