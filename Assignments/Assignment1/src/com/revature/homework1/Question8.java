package com.revature.homework1;

import java.util.ArrayList;
import java.util.List;

public class Question8 {

	public static void main(String[] args) {
		// Write a program that stores the following strings in an ArrayList and saves all the
		//palindromes in another ArrayList.
		//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”
		
		//Create name list and add our names to it
		List<String> names = new ArrayList<String>();
		names.add("karan");
		names.add("madam");
		names.add("tom");
		names.add("civic");
		names.add("radar");
		names.add("jimmy");
		names.add("kayak");
		names.add("john");
		names.add("refer");
		names.add("billy");
		names.add("did");
		
		//Create a list for palindromes and start adding to the list
		List<String> palindromes = new ArrayList<String>();
		for(String s : names) {
			if(checkPalindrome(s))
				palindromes.add(s);
		}
		
		//Print out the new name list
		System.out.println("Palindromes:");
		for(String s : palindromes) {
			System.out.println(s.toString());
		}
	}

	
	public static boolean checkPalindrome(String str) {
		
		//Make a string builder for easy reversal
		StringBuilder strcpy = new StringBuilder(str);
		
		//Return if the reversed string is the same as the original string
		return strcpy.reverse().toString().equalsIgnoreCase(str);
		
	}
}
