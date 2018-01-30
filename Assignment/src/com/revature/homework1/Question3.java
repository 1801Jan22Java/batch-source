package com.revature.homework1;

public class Question3 {

	public static void main(String[] args) {
		// Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
		
		String testWord = "watermelon";				
		reverse(testWord);
	}
	
	public static void reverse(String word) {
		String[] splitedWord = word.split("");		// split the given word  
		
		int wordLength = splitedWord.length;
		
		StringBuffer sb = new StringBuffer();		
		for (int a = wordLength ; a > 0 ; a--) {	// iterate from the end to the beginning of the given word
			sb.append(splitedWord[a-1]);			// and append to the StringBuffer Object
		}
		System.out.println("The result : " + sb.toString());
		
	}
}
