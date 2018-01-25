package com.revature.homework1;

import java.util.ArrayList;

/*
 * Q8. Write a program that stores the following strings in an 
 * ArrayList and saves all the palindromes in another ArrayList.
“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, 
“john”,  “refer”, “billy”, “did”

 * */
public class Question8 {
	
	public static ArrayList<String> storeStrings(String... args)
	{
		ArrayList<String> list= new ArrayList<String>();
		for(int i =0;i<args.length;i++)
		{
			list.add(args[i]);
		}
		return list;
	}
	
	public static ArrayList<String> storePalindromes(ArrayList<String> list)
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
	
	public static boolean isPalindrome(String str)
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
	
	public static void main(String [] args)
	{
		ArrayList<String>list = storeStrings("karan","madam", "tom", "civic", "radar","jimmy",
				"kayak","john","refer","billy","did");
		
		ArrayList<String>palindromes = storePalindromes(list);
		for(int i =0;i<palindromes.size();i++)
		{
			System.out.println(palindromes.get(i));
		}
		
	}
	

}
