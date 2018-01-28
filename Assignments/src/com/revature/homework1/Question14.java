package com.revature.homework1;
import java.util.Calendar;
/*
 * Write a program that demonstrates the switch case. Implement the following
functionalities in the cases:java
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array.
“I am learning Core Java”

 */
public class Question14 {
	
	public Question14(int caseNum, double number) {
		super();
		this.caseNum = caseNum;
		this.number = number;
	}

	public Question14(int caseNum) {
		super();
		this.caseNum = caseNum;
	}

	private int caseNum;
	private double number;
	private String str = "I am learning Core Java";

	public int getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(int caseNum) {
		this.caseNum = caseNum;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	
	public void doThing() {
		switch (caseNum) {
			case 1:
				System.out.println("Case 1 - number is " + number);
				System.out.println("Square root is " + Math.sqrt(number));
				break;
				
			case 2: 
				System.out.print("Case 2 - Today's date: ");
				System.out.println(Calendar.getInstance().getTime().toString());
				break;
				
			case 3:
				System.out.println("Case 3 - Starting string literal:");
				System.out.println(str);
				System.out.println("Splitting string, contents of array are: ");
				String[] coreJava = str.split(" ");
				for(int i = 0; i < coreJava.length; i++) {
					System.out.print("["+i+"] = " + coreJava[i] + "   ");
				}
				System.out.println();
				break;
		}
	}

}
