package com.revature.homework1;

import java.util.Scanner;
import java.lang.Math;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Question14 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter in a number, date, or word: ");
		int number = kb.nextInt();
		String date1 = kb.next();
		String words = kb.next();
		String[] arr = new String[1];
		
		switch(number) {
		case 1:
			System.out.println("The square root is: " + Math.sqrt(number));
			break;
		case 2:
			LocalDateTime datetime = LocalDateTime.parse(date1,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			System.out.println("Today's date is: " + date1);
			break;
			
		case 3: 
			System.out.println(words.split(words));
			break;
			
		}
		
	}
}
	
