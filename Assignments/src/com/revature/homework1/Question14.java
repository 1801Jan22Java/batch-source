package com.revature.homework1;
//James Whitten

import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;




public class Question14 {

	//Method implementing the switch case described for question 14
	//The integer parameter determines the number of iterations of the switch case
	public static void switchCase(int iterNum)
	{
		int randNum, randSwitch;
		double randRoot;
		String coreJavString = "I am learning Core Java";
		
		//Used to determine the switch case at random
		Random rand = new Random();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		//Iterations of the switch case
		for (int i = 0; i < iterNum; i ++)
		{
			//Random number for the switch case
			randNum = rand.nextInt(3);
			switch(randNum)
			{
			//Gets the square root of a very random number
			case 0:
				randSwitch = rand.nextInt(10000000)+1000;
				randRoot = Math.sqrt(randSwitch);
				System.out.println("The square root of " + randSwitch + " is " + randRoot);
				break;
			//Shows todays date and time
			case 1:
				Date date = new Date();
				System.out.println("The date and time is: " + dateFormat.format(date));
				break;
			//Splits the String "I am learning Core Java" and puts it in a String Array
			case 2:
				String[] javStringArray = coreJavString.split(" ");
				System.out.println("Each element in the String Array is: ");
				for (int j = 0; j < javStringArray.length; j++)
				{
					System.out.print(javStringArray[j] + " ");
				}
				System.out.println();
				break;
			//In case a number outside the switch is chosen somehow
			default:
				System.out.println("Something went wrong!");
				break;
					
				
			}
		}
	}
	
	//Our main
	public static void main(String[] args) {
		
		//test case
		switchCase(12);
		
		
		
	}
	
	
}
