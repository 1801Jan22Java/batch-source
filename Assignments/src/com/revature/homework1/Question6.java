package com.revature.homework1;
/*
 *  Write a program to determine if an integer is even without using the modulus operator (%)
 */
public class Question6 {

	public static void main(String[] args) {
		int num = 54961984;
		
		System.out.println("Is " + num +" even?");
		
		//Take advantage of integer truncating when dividing to see if the number divided evenly.
		int div = num / 2;
		if (div * 2 != num) {
			System.out.println("No");
		}
		else {
			System.out.println("Yes");
		}
		
	}
	
	
	
}
