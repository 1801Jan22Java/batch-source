package com.revature.homework1;

import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner kb = new Scanner(System.in);
		
		int i, fact=1;
		System.out.println("Enter a number ");
		int n= kb.nextInt();
		for(i=1;i<=n;i++) {
			fact=fact*i;
		}
		System.out.println("The fact of n is: " + fact);
}
}
