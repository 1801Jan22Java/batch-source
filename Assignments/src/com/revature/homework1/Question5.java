package com.revature.homework1;

import java.util.Scanner;

/*
 *Write a substring method that accepts a string str and an integer idx and returns the substring contained 
 *between 0 and idx-1 inclusive.  
 *Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
*/
public class Question5 
{
	public static String substring(String str, int n)
	{
		String sub = "";
		for(int i = 0; i < n; i++)
		{
			sub += str.charAt(i);
		}
		return sub;
	}
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);  
		System.out.print("Enter a String: ");
		String str = input.nextLine(); 
		System.out.println("How many characters of the string would you like back?");
		int n = input.nextInt()
;		System.out.println(substring(str,n));
	}
}
