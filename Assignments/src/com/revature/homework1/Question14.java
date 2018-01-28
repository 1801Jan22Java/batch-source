package com.revature.homework1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Question14 {
	public static void main(String[] args) {
		int caseNum = 0;
		Scanner scnr = new Scanner(System.in);
		for(;;) {
			System.out.println("Select a number from 1 to 3");
			try {
				caseNum = scnr.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Not a valid option. Goodbye.");
				scnr.close();
				System.exit(0);
			}
			
			switch(caseNum) {
				case 1:
					System.out.println("Pick a number:");
					int aNum = scnr.nextInt();
					System.out.println(Math.sqrt(aNum));
					break;
				case 2:
					LocalDate date = LocalDate.now();
					System.out.println(date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
					break;
				case 3:
					String str = "I am learning Core Java";
					String[] strAr = str.split(" ");
					for(String strang:strAr) {
						System.out.println(strang);
					}
					break;
				default:
					scnr.close();
					System.exit(0);
			}		
		}
	}
}
