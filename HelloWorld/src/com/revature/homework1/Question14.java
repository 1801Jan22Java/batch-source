package com.revature.homework1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Question14 {

	/*
	 * Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java 
		Case 1: Find the square root of a number using the Math class method.
		Case 2: Display today’s date.
		Case 3: Split the following string and store it in a string array.
		           	“I am learning Core Java”
	 */
	public static void main(String[] args) {
		
		int i = 3;			// caseNumber
		
		switch(i) {
		
			case 1 : 
				getSquareRoot(11);
				break;
			case 2 :
				getDate();
				break;
			case 3 :
				splitString();
				break;
		}
	}
	
	public static void getSquareRoot(int no) {
		System.out.println("the Square root of " + no + " is " + Math.sqrt(no));
	}
	
	public static void getDate() {
			Date d = new Date();														
			SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy a HH:mm:ss");		// month/day/year hour/min/second format to display today
			System.out.println(sf.format(d));
		}
	
	public static void splitString() {
		String word = "I am learning Core Java";
		String[] words = word.split("");
		ArrayList<String> wordsArr = new ArrayList<String>();
		for (String w : words) {
			wordsArr.add(w);
		}
		System.out.println(wordsArr.toString());
	}
}
