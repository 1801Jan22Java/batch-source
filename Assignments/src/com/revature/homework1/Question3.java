package com.revature.homework1;

import java.util.Scanner;

/*
 *  Reverse a string without using a temporary variable.  
 *  Do NOT use reverse() in the StringBuffer or the StringBuilder API
 */
public class Question3 
{
	public static String reverse(String st)
	{
		//This is returned, so technically not a bucket
		String rev = "";
		//This for loop will go from the last element of the string to the first
		//Then I just adds this character to the non-bucket reverse string variable
		for(int i =st.length()-1; i >= 0; i--)
		{
			rev += st.charAt(i);
		}
		return rev;
	}
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);  
		System.out.print("Enter a String: ");
		String str = input.nextLine(); 
		System.out.println(reverse(str));
		input.close(); 
	}
}
