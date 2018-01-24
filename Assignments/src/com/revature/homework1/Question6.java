package com.revature.homework1;

import java.util.Random;

/*
 *  Write a program to determine if an integer is even without using the modulus operator (%)
 */
public class Question6 {

	public static void main(String[] args) {
		int num;
		Random rand = new Random();
		
		
		
		for (int i = 0; i < 10; i++) {
			
			num = rand.nextInt();
			
			System.out.println("Is " + num +" even?");
			if (isEven(num)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		
	}
	
	//Checks to see if given number is even
	public static boolean isEven(int num) {
		//Take advantage of integer truncating when dividing to see if the number divided evenly.
		int div = num / 2;
		if (div * 2 != num) {
			return false;
		}
		return true;
	}
	
}
