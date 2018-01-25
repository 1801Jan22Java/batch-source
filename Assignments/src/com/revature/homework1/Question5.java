package com.revature.homework1;

import java.util.Scanner;

/**Created by: Jeffrey Rubi
 * Date: 24 January 2018
 * Write a substring method that accepts a string str and an integer idx and 
 * returns the substring contained between 0 and idx-1 inclusive.  Do NOT use 
 * any of the existing substring methods in the String, StringBuilder, or 
 * StringBuffer APIs.
 */

public class Question5 {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String str = input.nextLine();
		System.out.print("Enter an integer where you want to cut the string: ");
		int idx = input.nextInt();
		input.close();
		// String happy = "happy";
		
		// Output
		System.out.println("Your substring is: " + subString(str, idx));
	}
	
	public static String subString(String str, int idx) {
		// used 'String' class method, substring(int beginIndex, int endIndex)
		return str.substring(0, idx);
	}

}
