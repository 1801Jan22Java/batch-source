package com.revature.homework1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question18 
{
	public static void printMethods()
	{
		SubClass s = new SubClass();
		System.out.println("Testing if \'Jimmy\' has upper case letters: "+s.hasUpperCaseLetters("Jimmy"));
		System.out.println("Testing if \'jimmy\' has upper case letters: "+s.hasUpperCaseLetters("jimmy"));
	
		System.out.println("Converting lowercase letters to uppercase: "+s.toUpperCase("jimmy"));
		
		System.out.println("String \'10\' to int + 10: "+s.toIntPlusTen("10"));
	}
}

abstract class SuperClass
{
	public abstract boolean hasUpperCaseLetters(String s);
	
	public abstract String toUpperCase(String s);
	
	public abstract int toIntPlusTen(String s);
}

class SubClass extends SuperClass
{
	public boolean hasUpperCaseLetters(String s)
	{
		//flag
		boolean hasUpperCase = false;
		
		//check each character of the string
		for(int i = 0; i < s.length()-1; i++)
		{
			//if the character is uppercase,
			if(Character.isUpperCase(s.charAt(i)))
			{
				//set the flag to true
				hasUpperCase = true;
			}
		}
		return hasUpperCase;
	}
	
	public String toUpperCase(String s)
	{
		return s.toUpperCase();
	}
	
	public int toIntPlusTen(String s)
	{
		return Integer.parseInt(s) + 10;
	}
}