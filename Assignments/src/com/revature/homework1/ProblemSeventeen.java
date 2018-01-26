package com.revature.homework1;

import java.util.Scanner;

public class ProblemSeventeen {
	
	public static void main(String args[]) {
	//Accrued amount = Principal*(1+ Rate* Time)
	Scanner in = new Scanner(System.in);
	System.out.println("Please enter the principal amount : ");
	int principal = in.nextInt();
	
	System.out.println("Please enter the intrest rate : ");
	int intrest = in.nextInt();
	
	System.out.println("Please enter the time in years : ");
	int years = in.nextInt();
	
	System.out.print(principal*(1+(intrest*years)));

	
	}
	
}
