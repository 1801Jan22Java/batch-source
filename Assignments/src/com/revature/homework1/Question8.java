package com.revature.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Q8. Write a program that stores the following strings in an ArrayList and saves all the
// palindromes in another ArrayList. “karan”, “madam”, ”tom”, “civic”, “radar”, 
// “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”
// Created by: KP Saini
public class Question8 {

	public static void main(String[] args) {
		// create the list of words
		List<String> wordList = new ArrayList<>();
		Collections.addAll(wordList, "karan", "madam", "tom", "civic", "radar",
				"jimmy", "kayak", "john", "refer", "billy", "did");
		
		// print the original list to the console
		System.out.println("The list of words is: ");
		for (String s : wordList) {
			System.out.println(s);
		}
		
		// invoke getPalindromeList and print the returned list to the console 
		List<String> palindromeList = getPalindromeList(wordList);
		System.out.println("\nThe list of palindromes is: ");
		for (String s : palindromeList) {
			System.out.println(s);
		}
	}
	
	// take a list of strings as an argument and return a list of palindromes
	public static List<String> getPalindromeList(List<String> wordList) {
		List<String> palindromeList = new ArrayList<>();		// create palindrome list
		StringBuilder stringBuilder;						
		for (String s : wordList) {								// iterate through word list
			stringBuilder = new StringBuilder(s);
			String s2 = new String(stringBuilder.reverse());	// reverse each String
			if (s.equals(s2)) {									
				Collections.addAll(palindromeList, s2);			// add to palindromeList if a palindrome
			}
		}
		return palindromeList;
	}
}
