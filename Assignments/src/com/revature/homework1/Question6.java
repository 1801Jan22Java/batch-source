package com.revature.homework1;

public class Question6 {
	
	public static String isItEven(int n) {
		int check = n/2;
		
		if(check*2 == n) {
			return n + " is even";
		}
		else return n + " is odd";
	}
	
	public static void main(String[] args) {
		
		System.out.println(isItEven(32));
	}

}
