package com.revature.homework1;

import java.util.*;

public class Question14 {
	
	// number to square root
	private static int number = 27;
	
	// array to store the phrase into
	private static String [] arr = new String [5];
	
	private static final String phrase = "I am learning Core Java";
	
	public static void switchCases(int c) {
		
		switch(c) {
		case 1:
			System.out.println("the square root of " + number + " is " + Math.sqrt(number));
			break;
		case 2:
			Date date = new Date();
			System.out.println((date).toString()); 
			break;
		case 3:
			arr = phrase.split(" ");
			System.out.println(Arrays.toString(arr));
			break;
		default:
			break;
		}
	}
	
	public static void main(String[] args) {
		switchCases(1);
		switchCases(2);
		switchCases(3);
		
	}

}
