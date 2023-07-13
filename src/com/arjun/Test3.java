package com.arjun;

import java.util.HashMap;
import java.util.Map;

public class Test3 {

	public static void main(String[] args) {
		
      String input = "apple mango orange apple mango apple";
      
      Map<String, Integer> wordscount = new HashMap<>();
      
      String[] words= input.split(",");
      for(String word:words) {
    	  if (wordscount.containsKey(word)) {
    		  wordscount.put(word,wordscount.get(word)+ 1);
			
		}else {
			wordscount.put(word, 1);
		}
    	  
      }
      System.out.println(wordscount);
		
	}

}
