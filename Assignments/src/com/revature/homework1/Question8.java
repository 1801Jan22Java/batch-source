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
		words = new ArrayList<String>();
		palindromes = new ArrayList<String>();
	}
	
	public void doThing(){
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
		for(String temp: palindromes) {
			if(isPalindrome(temp)) {
				palindromes.add(temp);
				System.out.println("Found Palindrome: " + temp);
			}
		}
	}
	
	private boolean isPalindrome(String str) {
		str.trim();
		String temp = new StringBuilder(str).reverse().toString();
		return str.equals(temp);
	}

	public ArrayList<String> getWords() {
		return words;
	}

	public void setWords(ArrayList<String> words) {
		this.words = words;
	}

	public ArrayList<String> getPalindromes() {
		return palindromes;
	}

	public void setPalindromes(ArrayList<String> palindromes) {
		this.palindromes = palindromes;
	}
	
	
	
}
