package com.revature.homework1;

import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {
		
		int n, counter = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number to calculate the factorial: ");
		
		//get input from the user to calculate for N
		//counter grabs value of n and counts down in for loop
		n = sc.nextInt();
		counter = n;
		
		//for loop decrements counter until and stops before multiplying by 0
		for(int i = 1; counter > 0; counter--)
		{
			n *= i;  
			System.out.println(n + " " );
			i++;
		}
			
		sc.close();
	}

}
