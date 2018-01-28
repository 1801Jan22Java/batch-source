package com.revature.homework1;

import java.util.Scanner;

public class Question10 {

	public static void main(String[] args) {
		// Q10. Find the minimum of two numbers using ternary operators.

		int first, second, minVal;
		
		//get input from user using scanner and input it into two variables
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number: ");
		first = sc.nextInt();
		System.out.println("Enter the second number: ");
		second = sc.nextInt();
		
		//checks if the first is less than second; 
		//if returns true, then it will assign the first value to minVal
		//and if false assigns the second value to minVal
		minVal = (first < second) ? first : second;
		
		System.out.println("The minimum of the two is: ");
		System.out.println(minVal);
		
		sc.close();
	}

}
