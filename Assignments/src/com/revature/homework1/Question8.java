package com.revature.homework1;

import java.util.ArrayList;

public class Question8 {

	//Method for Checking if a String is a Palindrome
	public static boolean isPalindrome(String st)
	{
		//Checks if leftmost char == rightmost char and then keeps shifting inward by 1 for both sides
		for (int i = 0; i < st.length()/2; i++)
		{
			//Cannot be a palindrome there is a mismatch of characters
			if (st.charAt(i) != st.charAt(st.length() - i - 1))
					return false;
		}
		//If all chars match going inward 1 char at a time then it must be a palindrome
		return true;
	}
	
	//Method for adding Palindromes to an ArrayList
	public static void palAdding(ArrayList<String> aL, ArrayList<String> pL)
	{
		//We go through every String in the original ArrayList
		for (int i = 0; i < aL.size(); i++)
		{
			//If the String in the original ArrayList is a palindrome we add it to a new ArrayList
			if (isPalindrome(aL.get(i)))
					pL.add(aL.get(i));
		}
	}
	
	
	//Our main
	public static void main(String[] args)
	{
				
		//Our first ArrayList
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("karan");
		strList.add("madam");
		strList.add("tom");
		strList.add("civic");
		strList.add("radar");
		strList.add("jimmy");
		strList.add("kayak");
		strList.add("john");
		strList.add("refer");
		strList.add("billy");
		strList.add("did");
		
		//Our second ArrayList
		ArrayList<String> palList = new ArrayList<String>();
		
		//Adding palindromes to the second ArrayList
		palAdding(strList, palList);
		
		//Printing out all the palindromes of our second ArrayList
		for (int i = 0; i < palList.size(); i++)
		{
			System.out.println(palList.get(i));
		}
		
	
	
	
	}
}
