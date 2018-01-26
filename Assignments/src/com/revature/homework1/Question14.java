package com.revature.homework1;
import java.util.*;
import java.math.*;

public class Question14 {

	//computes square root using the sqrt() method in Math class
	public static void squareRoot(double num)
	{
		System.out.println("The square root of " + num + " is: " + Math.sqrt(num));
	}
	
	//prints out the current date
	public static void date()
	{
		Date today = new Date();
		System.out.println("Today's date is " +  today);
	}
	
	//splits the given array and stores it in a string array
	public static void split(String str)
	{
		System.out.println("Original String: "+ str);
		String[] list = str.split(" ");
		for (String s : list)
		{
			System.out.println(s);
		}
	}
	
	
	public static void main(String[] args) {
		
		double num = 49.0;
		String word = "I am learning core Java";
		for (int i = 1; i<=3; i++)					//test all the cases
		{
			switch (i) 
			{
				case 1: squareRoot(num); 	break;
				case 2: date(); 			break;
				case 3: split(word);		break;
			}
		}
	}

}
