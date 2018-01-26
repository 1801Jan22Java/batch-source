package com.revature.homework1;

import java.util.Scanner;

/*
 * Write a program having a concrete ;subclass that inherits three abstract methods from a superclass.  
 * Provide the following three implementations in the subclass corresponding to the abstract methods in the 
 * superclass:
 * 1. 	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
 * 2. 	Convert all of the lower case characters to uppercase in the input string, and return the result.
 * 3. 	Convert the input string to integer and add 10, output the result to the console.
 * Create an appropriate class having a main method to test the above setup.
 */
public class Question18 extends Question18Abstract
{

	@Override
	public boolean checkUppercase(String str) {
		for(char c: str.toCharArray())
		{
			if(Character.isUpperCase(c))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public String toLowercase(String str) 
	{
		String lowStr = "";
		for(int i = 0; i<str.length(); i++)
		{
			if(Character.isUpperCase(str.charAt(i)))
			{
				lowStr += Character.toLowerCase(str.charAt(i));
			}
			else
			{
				lowStr+=str.charAt(i);
			}
		}
		return lowStr;
	}

	@Override
	public void stringToIntAddTen(String str) 
	{
		System.out.println(Integer.parseInt(str)+10);
	}
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		Question18 q18 = new Question18();
		System.out.println("Check for upper case test");
		System.out.println("Enter a string");
		System.out.println(q18.checkUppercase(input.next()));
		System.out.println("Convert to lowercase test");
		System.out.println("Enter a string");
		System.out.println(q18.toLowercase(input.next()));
		System.out.println("Add 10 to a string test");
		System.out.println("Enter an \"In\"");
		q18.stringToIntAddTen(input.next());

	}
}
