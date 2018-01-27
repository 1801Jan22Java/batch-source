package com.revature.homework1;

import java.util.ArrayList;

public class Question12 {

	//Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. 
	//Use the enhanced FOR loop for printing out the numbers.
	public static void main(String[] args) {
		getArray();
	}
	
	public static void getArray(){
		
		ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
		int i = 0;
		while (i<100) {
			i++;
			if ((i/2)*2 == i) {
				evenNumbers.add(i);			// add only even numbers into ArrayList
			}
		}
		
		for (int n : evenNumbers) {			// enhanced FOR loop
			System.out.println(n);
		}
	}
}
