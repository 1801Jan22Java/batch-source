package com.revature.homework1;
import java.util.Date;
/*
 * Write a program that demonstrates the switch case. Implement the following
functionalities in the cases:java
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array.
“I am learning Core Java”

 */
public class Question14 {
	
	public Question14(int caseNum) {
		super();
		this.caseNum = caseNum;
	}

	private int caseNum;
	private double number;
	private long date;
	private String[] coreJava;
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

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}
	
	public void doThing() {
		Date theDay = new Date(date);
		switch (caseNum) {
			case 1:
				System.out.println("Case 1 - number is " + number);
				System.out.println("Square root is " + Math.sqrt(number));
				break;
				
			case 2: 
				System.out.println("Case 2 - given milliseconds: " + date);
				System.out.println("Date from given milliseconds: " + theDay.toString());
				break;
				
			case 3:
				System.out.println("Case 3 - Starting string literal:");
				System.out.println(str);
				System.out.println("Splitting string, contents of array are: ");
				coreJava = str.split(str);
				int i = 0;
				for(String s: coreJava) {
					System.out.println(coreJava[i]);
					i++;
				} // why a for-each loop instead of a normal for? 
				  // because I felt like doing so. Yay rebellion. 
				break;
		}
	}

}
