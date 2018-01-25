package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Write a program that stores the following strings in an ArrayList and saves all the palindromes in another 
 * ArrayList.“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”
 */
public class Question8 
{
	public static boolean isPalindrome(String s)
	{
		Question3 q3 = new Question3();
		if(q3.reverse(s).equals(s))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static ArrayList<String> justThePalindromes (ArrayList<String> words)
	{
		ArrayList<String> pals = new ArrayList<String>();
		for(String s: words)
		{
			if(isPalindrome(s))
			{
				pals.add(s);
			}
		}
		return pals;
	}
	public static void main(String args[])
	{
		ArrayList<String>  words = new ArrayList<String>();
		words.addAll(Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"));
		System.out.println((words.toString()));
		System.out.println(justThePalindromes(words).toString());
	}
}
