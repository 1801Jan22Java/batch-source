package com.revature.homework1;

import java.util.Scanner;

public class Question17 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the Principal");
		double principal = s.nextDouble();
		
		
		System.out.println("Enter the rate of interest");
		double rate = s.nextDouble();
		
		
		System.out.println("Enter the time in years");
		double time = s.nextDouble();
		
		System.out.println("The simple interest is: "+ principal*(1+rate*time));
		
		//gotta close those streams
		s.close();
	}
}
