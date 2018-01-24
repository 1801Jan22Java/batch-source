package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Homework 1. Question 8. Weeding palindromes.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question8 {
	
	/**
	 * Returns true if given string is a palindrome. False otherwise.
	 * 
	 * @param s String to be determined if palindrome
	 * @throws IllegalArgumentException if s is null
	 * @return true if s is a palindrome. False otherwise.
	 */
	private static boolean isPalindrome(String s) {
		if (s == null) {
			throw new IllegalArgumentException();
		}
		
		int lowerLim = 0;
		int higherLim = s.length() - 1;
		
		boolean result = true;
		
		// If result is false, no point continuing. Also, if lowerLim >= higherLim,
		// then we made sure that a mirrored image exists up till half the length of
		// the word, which makes it a palindrome.
		while (result == true && lowerLim < higherLim) {
			result = s.charAt(lowerLim) == s.charAt(higherLim);
			
			lowerLim++;
			higherLim--;
		}
		
		return result;
	}
	
	/**
	 * Given an array of strings, puts all palindromes into one array list
	 * and the rest in the other. The given array lists must be given empty.
	 * Word array must not contain null values.
	 * 
	 * @param words The array of words
	 * @param palindromes An array list to contain all palindromes
	 * @param nonpalindromes An array list to contain all non-palindromes
	 * @modifies palindromes, nonpalindromes
	 * @throws IllegalArgumentException if words, palindromes, or nonpalindromes are null
	 * @throws IllegalStateException if palindromes or nonpalindromes are not empty
	 * @return No return value
	 */
	private static void separatePalindromes(String[] words, List<String> palindromes, 
			List<String> nonpalindromes) {
		if (words == null || palindromes == null || nonpalindromes == null) {
			throw new IllegalArgumentException();
		}
		
		if (!palindromes.isEmpty() || !nonpalindromes.isEmpty()) {
			throw new IllegalStateException();
		}
		
		for (String word : words) {
			if (isPalindrome(word)) {
				palindromes.add(word);
			} else {
				nonpalindromes.add(word);
			}
		}
	}

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		String[] words = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		
		System.out.println("Out of these words:");
		System.out.println(Arrays.toString(words));
		
		List<String> palindromes = new ArrayList<String>();
		List<String> nonpalindromes = new ArrayList<String>();
		
		separatePalindromes(words, palindromes, nonpalindromes);
		
		System.out.println("The palindromes are: " + palindromes.toString());
		System.out.println("Furthermore, the non-palindromes are: " + nonpalindromes.toString());
		
	}

}
