package com.revature.homework1;

import java.util.*;

class Question8{
	
	public static void main(String[] args) {
	ArrayList<String> somePalindromes = new ArrayList<String>();
	ArrayList<String> palindromes = new ArrayList<String>();
	somePalindromes.add("karan");
	somePalindromes.add("madam");
	somePalindromes.add("tom");
	somePalindromes.add("civic");
	somePalindromes.add("radar");
	somePalindromes.add("jimmy");
	somePalindromes.add("kayak");
	somePalindromes.add("john");
	somePalindromes.add("refer");
	somePalindromes.add("billy");
	somePalindromes.add("did");
	for (String candidate: somePalindromes) {
		if (isPalindrome(candidate))
			palindromes.add(candidate);
	}
	//for (String palindrome: palindromes)
		//System.out.println(palindrome);
}
	
	static boolean isPalindrome(String source) {
        int start = 0;
		int end = source.length() - 1;
		for (int i = 0; i < source.length() / 2; i++){
			if (source.charAt(start) != source.charAt(end))
				return false;
			start += 1;
			end -= 1;
		}
		return true;
	}
}