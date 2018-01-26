package com.revature.homework1;

public class Question16 {

	public static void main(String[] args) {

		//check to see if args is empty
		if (args.length >0)
		{
			System.out.println("The number of characters in " + args[0]+ " is " + args[0].length());
		}
		//else print error message
		else 
		{
			System.out.println("You did not enter a String");
		}

	}

}
