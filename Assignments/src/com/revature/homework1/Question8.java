package com.revature.homework1;

import java.util.*;
public class Question8 {
	
	private static String [] arr = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};
	
	private static ArrayList<String> forward = new ArrayList<String>();
	
	private static ArrayList<String> palindrome = new ArrayList<String>();
	
	// use stringbuilder to reverse the string and place in palindrome arraylist
	public static void fillPalindrome() {
		for (int i = 0; i < arr.length; i ++) {
			String str = arr[i];
			forward.add(str);
			StringBuilder sb = new StringBuilder(str);
			String reverse = sb.reverse().toString(); 
			if (reverse.equals(str)) {
				palindrome.add(reverse);
			}
		}
	}
			
	public static void main(String[]args) {
		
		fillPalindrome();
		System.out.println("forward:" + forward.toString());
		System.out.println("palindromes: " + palindrome.toString());
		
	}
}
