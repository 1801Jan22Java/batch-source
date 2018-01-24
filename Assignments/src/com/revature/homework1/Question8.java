package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Write a program that stores the following strings in an ArrayList and saves all the palindromes in another 
 * ArrayList.
 * “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
 */

public class Question8 {

	public static void main(String[] args) {
		
		String[] array = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", 
				"john",  "refer", "billy", "did"};
		
		makeArrayLists(array);
		
		String[] array2 = {"Bob", "people", "greg", "yay", "dad", "root", "ogopogo", 
				"deer",  "wow", "bill", "pop"};
		
		makeArrayLists(array2);
		
		
		
	}

	//Puts the array into an ArrayList then makes a new ArrayList with the palindromes
	public static void makeArrayLists(String[] array) {
		
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> palindromes = new ArrayList<>();
		
		//Put array into ArrayList
		for (String str : array) {
			list.add(str);
		}
		
		//Find Plaindromes and put them into an ArrayList
		for (String str : list) {
			if (isPalindrome(str)) {
				palindromes.add(str);
			}
		}
		
		System.out.println(list.toString());
		System.out.println(palindromes.toString());
		
		
		
	}
	
	//Checks to see if the String is a palindrome
	public static boolean isPalindrome(String str) {
		StringBuilder builder = new StringBuilder(str);
		String str2 = builder.reverse().toString();
		
		return str.equals(str2);
	}
}
