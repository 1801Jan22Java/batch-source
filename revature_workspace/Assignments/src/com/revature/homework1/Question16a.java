package com.revature.homework1;

import java.util.Scanner;

public class Question16a {
	
	public static int countChars(String s)
	{
		int charCount =0;
		String strArr[]=s.split(" ");
		for(int i=0;i<strArr.length;i++)
		{
			charCount+=strArr[i].length();
		}
		return charCount;
	}
	
	public static void main(String []args)
	{

		Scanner sc = new Scanner (System.in);
		System.out.println("Please enter a string: ");
		String s =sc.nextLine();
		System.out.println("Your string contained " + countChars(s) + " characters.");
		
		
	}

}
