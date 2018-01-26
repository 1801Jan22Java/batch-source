package com.revature.homework1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Question14 {
	
	public static void switchCase(int java) {
		switch(java) {
		case 1:
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the number you want the square root of: ");
			Double num = sc.nextDouble();
			System.out.println(Math.sqrt(num));
			break;
		case 2:
			LocalDate currentDate = LocalDateTime.now().toLocalDate();
			System.out.println(currentDate);
			break;
		case 3:
			String str = "I am learning Core Java";
			String[] strArray = str.split(" ");
			System.out.println(Arrays.toString(strArray));
			break;
		default:
			System.out.println("Choose one of the cases!");
			break;
		
		}
	}
}
