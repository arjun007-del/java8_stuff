package com.arjun;

import java.util.HashMap;
import java.util.Map;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Welcome to the coding round Welcome to Altimetrik first level technical round";
		
		Map<String, Integer> wordcounts = new HashMap<>();
		
		String[] words = str.split("\\s+");
		for(String word:words) {
		 if (wordcounts.containsKey(word)) {
			 wordcounts.put(word, wordcounts.get(word)+ 1);
			
		}
		 else {
			wordcounts.put(word, 1);
		}
		}
		System.out.println(wordcounts);

	}

}
