package com.revature.homework1;

/**Created by: Jeffrey Rubi
 * Date: 25 January 2018
 * Write a program that stores the following strings in an ArrayList and saves all the palindromes in another 
 * ArrayList. “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Question8 {

	public static void main(String[] args) {

		List<String> nonPalindromes = new ArrayList<String>();
		List<String> palindromes = new ArrayList<String>();

		// Create an array to store strings
		String[] raw = { "karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did" };

		System.out.print("Raw data to be processed: ");
		for (String str : raw) {
			System.out.print(str + " ");
			if (isPalindrome(str)) {
				palindromes.add(str);
			} else {
				nonPalindromes.add(str);
			}
		}

		// ArrayList to store raw data.
		List<String> toProcess = new ArrayList<String>();
		for (String str : raw) {
			toProcess.add(str);
		}

		// Display
		System.out.println("\nData in ArrayList: ");
		System.out.println(toProcess);

		System.out.println("List of none palindromes: ");
		System.out.println(nonPalindromes);

		System.out.println("List of palindromes: ");
		System.out.println(palindromes);

	}

	/*
	 * Method for checking whether a string is a palindrome. It iterates through the
	 * string characters, if the letter is not in the HM (HashMap), it stores the
	 * character as key and increments value associated with that character.
	 */
	public static boolean isPalindrome(String input) {
		int countOdd = 0;
		Map<String, Integer> map = new HashMap<>();
		String step1 = input.toLowerCase(); // in case user inputs uppercase
		String stmt = step1.replace(" ", ""); // ignores space
		for (int i = 0; i < stmt.length(); i++) {
			String key = String.valueOf(stmt.charAt(i));
			if (!map.containsKey(key)) {
				map.put(key, 1);
				countOdd++;
			} else {
				int value = map.get(key);
				value++;
				if (value % 2 == 1) {
					countOdd++;
				} else {
					countOdd--;
				}
				map.put(key, value);
			}
		}
		return (countOdd <= 1);
	}

}
