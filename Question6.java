package com.revature.homework1;

import java.util.Scanner;
public class Question6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int number = kb.nextInt();
		int[] even = {2,4,6,8,10};
		if(number != even.length) {
			System.out.println("This number is not even");
		}
		else {
			System.out.println("This number is even");
		}
	}

}
