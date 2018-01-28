package com.revature.homework1;

public class Question14 {
	public static String switcher (int theCase, double ... number) {
		int switchCase = theCase;
		// switch statement based on passed theCase argument
		switch (switchCase) {
		// gets the square root of the passed number argument
		case 1: return ((Double) Math.sqrt(number[0])).toString();
		// returns the Date
		case 2: return new java.util.Date().toString();
		// returns the string "I am learning Core Java" split
		case 3: String[] split = (new String("I am learning Core Java")).split(" ");
				return java.util.Arrays.toString(split);
		// in case of invalid switchCase
		default: return "Invalid switch case = " + switchCase;
		}
	}
}
