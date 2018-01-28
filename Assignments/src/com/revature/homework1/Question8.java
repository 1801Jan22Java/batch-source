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
		for(int i = 0; i < words.size(); i++) {
			if(isPalindrome(words.get(i))) {
				palindromes.add(words.get(i));

			}
		}
		for(String temp: palindromes) {
			System.out.println(temp);
		}
	}
	
	private boolean isPalindrome(String str) {
		str.trim();
		Question3 q3 = new Question3(str);
		String temp = q3.getReversed();
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
