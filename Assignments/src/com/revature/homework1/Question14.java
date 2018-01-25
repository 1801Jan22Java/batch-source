package com.revature.homework1;

import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.GregorianCalendar;

/*
 * Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java 
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array.
           	“I am learning Core Java”

 */

public class Question14 {

	public static void main(String[] args) {


		System.out.println(switchExample(1));
		System.out.println(switchExample(1));
		System.out.println(switchExample(1));
		System.out.println(switchExample(2));
		System.out.println(switchExample(3));

	}
	
	public static String switchExample(int num) {
		Random rand = new Random();
		double sqrt;
		String rtn = "";
		String[] array;
		String str = "I am learning Core Java";
		switch (num) {
		
		case 1:
			sqrt = Math.abs(rand.nextInt(100));
			rtn = "The square root of " + sqrt + " is " + Math.sqrt(sqrt);
			break;
		case 2:
			rtn = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			break;
		case 3:
			array = str.split(" ");
			rtn = Arrays.toString(array);
			break;
			
		
		}
		
		return rtn;
		
	}

}
