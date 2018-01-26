package com.revature.homework1;

import java.util.ArrayList;

public class Question8 {
	
	public static void palindrome(ArrayList<String> arrayList) {
		ArrayList<String> isAPalindrome = new ArrayList<String>();
		for(String str : arrayList) {
			//For every string, change to StringBuilder in order to use the reverse method
			//Compare the String object of the reversed string to original string
			//If the values are the same, add to new ArrayList.
			StringBuilder strBuilder = new StringBuilder(str);
			if(str.equals(strBuilder.reverse().toString())) {
				isAPalindrome.add(str);
			}
		}
		System.out.println(isAPalindrome);
	}
}
