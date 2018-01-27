package com.revature.homework1;

import java.util.*;

public class Question17 {
	
	public static void interest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the following values");
		System.out.print("Principal:");
		Double principal = scan.nextDouble();
		System.out.print("Rate:");
		Double rate = scan.nextDouble();
		System.out.print("Time:");
		Double time = scan.nextDouble();
		
		System.out.println("Accrued amount: " + principal*(1 + rate*time));
	}
	
	public static void main(String[] args) {
		interest();
	}

}
