package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Calvin Milliron
 * Assignment: Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
 * 		"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"
 * Status: Done
 */
public class Question08 {

	public static void main(String[] args) {
		// Build and display the initial array
		ArrayList<String> initial = new ArrayList<>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"));
		System.out.println("The original list is:\t" + initial);
		// Create new array for palindromes
		ArrayList<String> palindromes = new ArrayList<>();
		// Check each element of array, add to new array if palindrome
		for(String x : initial) {
			if (isPalindrome(x)) {
				palindromes.add(x);
			}
		}
		// Display result
		System.out.println("The palindromes are:\t" + palindromes);
		
	}
	
	public static boolean isPalindrome(String str) {
		boolean isPalindrome = true;
		// Save the last index of the string for stepping backwards
		int j = str.length() - 1;
		// Step through forward with i and backwards with j comparing each character
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(j)) { isPalindrome = false; }
			j--;
		}
		// Returns false if even one character did not match
		return isPalindrome;
	}

}
