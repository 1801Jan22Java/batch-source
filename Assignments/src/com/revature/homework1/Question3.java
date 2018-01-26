package com.revature.homework1;
/*
 * This class reverses a string 
 */
public class Question3 {
	
	
	private static void reverse(String str)
	{
		System.out.println("Original String: " + str);			//print String
		System.out.print("Reversed String: ");					
		for (int i=str.length()-1; i>=0; i--)					//loops through the string starting from the end
		{
			System.out.print(str.charAt(i));					//print character at specified index
		}
		System.out.println();
	}
	
	
	public static void main(String[] args)
	{
		String word = "Hello";
		reverse(word);
	}

}
