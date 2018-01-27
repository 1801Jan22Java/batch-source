package com.revature.homework1;
/*
 * Q14. Write a program that demonstrates the switch case. Implement the following functionalities 
 * in the cases:java 
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array.
           	“I am learning Core Java”

Refer to Generics in Notes under 1/25/2018
 * 
 * */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Question14 {
	
	int squareInt=0;
	private void setInputInteger(int inputInt)
	{
		squareInt=inputInt;
	}
	/*
	 * valiateInput validates String input
	 * ensures that user chooses an option between 1 and 3
	 * returns 0 if input is invalid
	 * @param String input
	 * @return int inputInt
	 * */
	public int validateInput(String input)
	{
		char [] inputArr=input.toCharArray();
		int inputInt=0;
		for(char a:inputArr)
		{
			inputInt+= Character.getNumericValue(a);
		}
		if(inputInt<=0 || inputInt>= 4)
		{
			inputInt=0;
		}
		return inputInt;
	}
	/*
	 * Validates input given by user for the number for which they want the square root
	 * Calls setInputInteger
	 * returns true if input is valid
	 * returns false and calls the stack trace if input is invalid
	 * @param String input
	 * @return boolean
	 * */
	
	public boolean validateIntegerInput(String input)
	{
		int inputInteger=0;
		boolean valid =false;
		try{
			 inputInteger= Integer.parseInt(input);
			 setInputInteger(inputInteger);
			 valid=true;
		}
		catch(InputMismatchException e)
		{
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		finally{
		return valid;
		}
	}
	/*
	 * returns a square root of a user input number
	 * @param int
	 * @return Double result
	 * */
	private Double getSquareRoot(int num)
	{
		double square = (double)num;
		double result = Math.sqrt(square);
		return result;
	}
	/*
	 * Displays today's date;
	 * @param none
	 * @return void
	 * */
	private void showDate()
	{

		LocalDate ldt1 =  LocalDate.now();
		System.out.println(ldt1);
	}
	
	/*
	 * Displays string split into an array of smaller strings line by line
	 * @param none
	 * @return void
	 * */
	private void showLearningString()
	{
		 String learning = "I am learning Core Java"; String [] learningArr = learning.split(" "); 
			for(int i =0;i<learningArr.length;i++)
			{
				System.out.println(learningArr[i]);
			}
	}
	
	/*
	 * Chooses between three choices (1 through 3)
	 * if user chooses 1, user is prompted to choose an integer for which they want to find the square root.
	 * if user chooses 2, prints out the date
	 * if user chooses 3, prints out a string that says "I am learning Core Java"
	 * Displays "Invalid choice" if user selects none of the above.
	 * @param int
	 * @return none
	 * */
	public void switchRun(int input)
	{
		
		switch((Integer)input)
		{
		case 1: Scanner sc = new Scanner(System.in); 
				System.out.println("Please enter an integer:   "); 
				String a = sc.nextLine();
				//Makes sure that the user inputs an integer
				while(!validateIntegerInput(a))
					{System.out.println("Please enter an integer:  "); 
						a=sc.nextLine();
						}
				System.out.println( getSquareRoot(squareInt));
		case 2: showDate(); break;
		case 3:showLearningString();break;
		default: System.out.println("Invalid choice");
		}
		
	}
}
