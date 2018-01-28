package com.revature.homework1;

import java.util.Scanner;

public class Question17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the principal ");
		double principal = kb.nextDouble();
		System.out.println("Enter the rate ");
		double rate = kb.nextDouble();
		System.out.println("Enter the number of years ");
		int year = kb.nextInt();
		
		double accurredAmount = principal * (1+rate*year);
		
		System.out.println("The accurred amount is " + accurredAmount);

	}

}
