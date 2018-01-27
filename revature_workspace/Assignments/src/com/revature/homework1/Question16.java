package com.revature.homework1;
/*
 * 
Q16. Write a program to display the number of characters for a string input. 
The string should be entered as a command line argument using (String [ ] args).

 * */
public class Question16 {
	

	
	public static int countChars(String[] strings){
		int charCount=0;
		int charCountMinusSpaces=0;

		for(int i =0;i<strings.length;i++)
		{
			
			charCount++;
		}
		return charCount;
		
	} 
	public static void main(String []args)
	{
		
		countChars(args);
	}

}
