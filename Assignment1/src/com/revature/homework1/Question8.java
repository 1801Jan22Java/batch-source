package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question8 
{
	public static void wordsAndTheirPalindromes()
	{
		String w0 = "karan";
		String w1 = "madam";
		String w2 = "tom";
		String w3 = "civic";
		String w4 = "radar";
		String w5 = "jimmy";
		String w6 = "kayak";
		String w7 = "john";
		String w8 = "refer";
		String w9 = "billy";
		String w10 = "did";
		
		//Create a list
		ArrayList<String> words = new ArrayList<String>();
		//add the words to the list
		Collections.addAll(words,w0,w1,w2,w3,w4,w5,w6,w7,w8,w9,w10);
		
		//Create a list to hold the palindromes
		ArrayList<String> palindromes = new ArrayList<String>();
		
		
		//flag
		boolean isPalindrome = true;
		
		//counter
		int i = 0;
		for(String s : words)
		{
			//reset counter and flag when checking each word.
			i = 0;
			isPalindrome = true;
			
			//if the length of the string is odd
			if(!Question6.isEven(s.length()))
			{
				//the number of times you check the ends of the current string
				//is the (length of the string-1)/2
				int checks = (s.length()-1)/2;
				while(i < checks)
				{
					//if the characters on the ends of the string do not match
					//the string is not a palindrome
					if(s.charAt(i) != s.charAt(s.length()-(i+1)))
						isPalindrome = false;
					i++;
				}
			}
			//same as above, but if the length of the string is even
			else
			{
				while(i < s.length()/2)
				{
					if(s.charAt(i) != s.charAt(s.length()-(i+1)))
						isPalindrome = false;
					i++;
				}
			}
			//if the word is a palindrome, add it to the list to be printed.
			if(isPalindrome)
				palindromes.add(s);
		}
		//print the contents of the palindrome list.
		System.out.println(Arrays.toString(palindromes.toArray()));
	}
}
