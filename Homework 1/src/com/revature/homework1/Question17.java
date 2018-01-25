//Done!
//Straightforward; just take the desired input, plug it into the equation
//Accrued amount = Principal*(1+ Rate* Time)
//And print the result

package com.revature.homework1;
import java.util.Scanner;

public class Question17 {
	public static void main(String[] args) {
		double principal, rate, time;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the principal amount: ");
		principal = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Enter the rate of interest: ");
		rate = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Enter the number of years: ");
		time = sc.nextDouble();
		
		System.out.println("The accrued amount = " + (principal*(1+rate*time)));
		sc.close();
	}
}
