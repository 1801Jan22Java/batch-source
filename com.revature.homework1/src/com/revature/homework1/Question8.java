package com.revature.homework1;

import java.util.*;

public class Question8 {

	public static void main(String[] args) {
		//Q8. Write a program that stores the following strings in an ArrayList and 
		//saves all the
		//palindromes in another ArrayList.
		//“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”,
		//“john”, “refer”, “billy”, “did”
		
		//crerate two array list, first being the initial array list
		//and palindromes holding the first elements which are palindromes
		ArrayList<String> palindromes = new ArrayList<String>();
		ArrayList<String> first = new ArrayList<String>();
		int x = 0;
		boolean result = false;
		
		first.add("karan");
		first.add("madam");
		first.add("tom");
		first.add("civic");
		first.add("radar");
		first.add("jimmy");
		first.add("kayak");
		first.add("john");
		first.add("refer");
		first.add("billy");
		first.add("did");
		
	
		//for loop which converts the element of the first array list
		//and calls isPalindrome which checks if the char array is a palindrome
		//if result returns true, it will convert it back to a string and
		//add it to palindromes and output it to the console
		for(int i = 0; i < first.size(); i++)
		{
			char[] toChar = first.get(i).toCharArray();
			result = isPalindrome(toChar);
			String newString = new String(toChar);
			if(result == true)
			{	
				palindromes.add(newString);
				System.out.println(palindromes.get(x));
				++x;
			}
		}
		
		}
		
	//checks the character array to see if it is the same
	//if reversed
	public static boolean isPalindrome(char[] word)
	{
		int i1 = 0;
		int i2 = word.length -1;
		while(i2 > i1)
		{
			if(word[i1] != word[i2])
			{
				return false;
			}
			++i1;
			--i2;
		}
		return true;
	}
		
}

