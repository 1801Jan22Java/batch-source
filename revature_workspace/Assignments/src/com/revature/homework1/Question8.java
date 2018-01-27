package com.revature.homework1;

import java.util.ArrayList;

/*
 * Q8. Write a program that stores the following strings in an 
 * ArrayList and saves all the palindromes in another ArrayList.
“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, 
“john”,  “refer”, “billy”, “did”

 * */
public class Question8 {
	
	/*Stores strings as a varargs in an ArrayList of Strings
	 * returns ArrayList<String> list
	 * @param String... args
	 * @return ArrayList<String> list
	 * */
	public ArrayList<String> storeStrings(String... args)
	{
		ArrayList<String> list= new ArrayList<String>();
		for(int i =0;i<args.length;i++)
		{
			list.add(args[i]);
		}
		return list;
	}
	/*
	 * Stores those strings which are palindromes.
	 * accepts input of ArrayList<String> list and returns an ArrayList<String> palindromes
	 * Iterates through list and calls isPalindrome() on list.get(i)
	 * Adds strings that return true to palindromes.
	 * @param ArrayList<String> list
	 * @return ArrayList<String> palindromes
	 * */
	public ArrayList<String> storePalindromes(ArrayList<String> list)
	{
		
		ArrayList<String>palindromes = new ArrayList<String>();
		for(int i = 0;i<list.size();i++)
		{
			if(isPalindrome(list.get(i)))
			{
				palindromes.add(list.get(i));
			}
		}
		return palindromes;
	}
	
	/*
	 * checks if string str is a palindrome
	 * Takes in a string and returns true is string is a palindrome and false if it is not
	 * divides string in half, ignoring middle character if str.length is odd, 
	 * and reverses latter half of string and compares reversed second half to first half.
	 * if two halves are equal, returns true;
	 * @param String str
	 * @return boolean palindrome
	 * */
	private boolean isPalindrome(String str)
	{
		boolean palindrome=false;
		String str1=str.substring(0,str.length()/2);
		String str2=str.substring(str.length()/2+1);
		char[] arr= str2.toCharArray();
		String rev="";
		for(int i =arr.length-1;i>=0;i--)
		{
			rev+=arr[i];
		}
	//	System.out.println(str1);
	//	System.out.println(rev);
		if(str1.equals(rev))
		{
			palindrome=true;
		}
		return palindrome;
		
	}
	

}
