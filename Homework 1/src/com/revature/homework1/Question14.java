//Done!

package com.revature.homework1;
import java.util.*;

public class Question14 {
	
	
	public static void main(String[] args) {
		/*
		 * SET THE INT FOR THE DESIRED FUNCTIONALITY HERE
		 * 1 = Find the square root of a number using the Math class method.
		 * 2 = Display today's date.
		 * 3 = Split the following string and store it in a string array.
		 */
		System.out.println("Enter the appropriate integer for the desired functionality");
		System.out.println("1 = Find the square root of a number using the Math class method.");
		System.out.println("2 = Display today's date.");
		System.out.println("3 = Split the following string and store it in a string array.");
		Scanner sc = new Scanner(System.in);
		int switchNum = sc.nextInt();
		sc.nextLine();
		
		switch(switchNum) {
		case 1 : 	System.out.println("Enter the number you'd like to find the square root of: ");
					double squareRoot = Math.sqrt(sc.nextDouble());		//Take the square root of the next double
					sc.nextLine(); 
					System.out.println("The square root is: " + squareRoot);	//And print it
					break;
		case 2 :	Date d = new Date();	//Create a new Date object
					System.out.println("The date is: " + d.toString());		//Call toString() on it and print it
					break;
		case 3 :	String str = "I am learning Core Java";
					String[] words = str.split(" ");			//Split str using a space as the delimiter
					System.out.println("Splitting: " + str);
					for(String word : words) {					
						System.out.println(word);				//Print each word on a separate line
					}
					break;
		}
		sc.close();
	}
}
