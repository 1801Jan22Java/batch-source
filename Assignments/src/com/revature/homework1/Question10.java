package com.revature.homework1;

public class Question10 {
	public static void main(String[] args) {
		System.out.println(min(1, 3));
		System.out.println(min(10, 3));
		
	}
	
	public static int min(int a, int b) {
		return a > b ? b : a;
	}
}
