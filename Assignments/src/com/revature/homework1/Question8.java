package com.revature.homework1;


import java.util.ArrayList;
import java.util.Arrays;

public class Question8 {
	public static void main(String[] args) {
		
		// Convert the list of words to an ArrayList.
		// To save coding time, it was made a List first, then
		// 	into an ArrayList.
		// There is an obvious overhead to this method, however.
		ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(
				"karan", "madam", "tom", "civic", "radar", "jimmy", 
				"kayak", "john",  "refer", "billy", "did"));
		
		// ArrayList for palindromes
		ArrayList<String> palindromes = new ArrayList<String>();
		
		// Find palindromes using StringBuilder's reverse() method
		for(String word : wordList) {
			StringBuilder original = new StringBuilder(word);

			// Reverse and convert back to String
			String reversed = original.reverse().toString();
			
			// If reversed string is equivalent to the original, 
			// place in palindromes ArrayList
			if(word.equals(reversed)) {
				palindromes.add(word);
			}
		}
		System.out.println(palindromes);
	}
	
	
 
}
