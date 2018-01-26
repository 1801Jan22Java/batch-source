package com.revature.homework1;
import java.util.ArrayList;
/*
 * Write a program that stores the following strings in an ArrayList and saves all the
palindromes in another ArrayList.
“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”
 */
public class Question8 {
	
	private ArrayList<String> words;
	private ArrayList<String> palindromes;
	
	public Question8() {
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
	}
	
	public ArrayList<String> findPalindromes(){
		
		for(String temp: palindromes) {
			if(isPalindrome(temp)) {
				palindromes.add(temp);
				System.out.println("Found Palindrome: " + temp);
			}
		}
		
		return palindromes;
	}
	
	private boolean isPalindrome(String str) {
		int j = str.length();
		for(int i = 0; i < str.length(); i++) {
			if(i == j)
				break;
			else {
				if(str.charAt(i) != str.charAt(j))
					return false;
			}
			j--;
		}
		return true;
	}
	
	
	
}
