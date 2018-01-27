package com.revature.homework1;

import java.util.Arrays;

/*
 *  Reverse a string
 */
public class Question3 {
	
	// made private, can later be made using inputs 
	private static String forward = "forward";
	
	// make a method that doesnt take any inputs uses the forward variable to reverse
	public static String reverse() {
		
		return insideReverse(forward);
	}
	
	// make a method that takes in an input to reverse
	public static String reverse(String str) {
		
		return insideReverse(str);
	}
	
	// does the majority of the work
	private static String insideReverse(String str) {
		

		// changes string into an array of the letters
		String [] arr = str.split("");
		for (int i = 0; i < arr.length/2; i ++) {
			String temp = arr[i];
			arr[i] = arr[arr.length -1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		String rev = String.join("",arr);
		return rev;
		
	}
	public static void main(String[] args) {
		System.out.println(reverse());
		
	}

}
