package com.arjun;

public class ReverseStringSentence {
	
	 public static void main(String[] args) {
	        String str = "Hello World!";
	        String reversedString = reverseWords(str);
	        System.out.println(reversedString);
	    }

	    public static String reverseWords(String str) {
	        String[] words = str.split(" ");
	        StringBuilder reversed = new StringBuilder();
	        for (int i = words.length - 1; i >= 0; i--) {
	            reversed.append(words[i]).append(" ");
	        }
	        return reversed.toString().trim();
	    }
	}


