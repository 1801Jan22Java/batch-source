package com.revature.homework1;

public class Question15Math implements Question15Interface {
	


	@Override
	public int addition(int num1, int num2) {
		return (num1 + num2);
	}

	@Override
	public int subtraction(int num1, int num2) {
		return (num1 - num2) ;
	}

	@Override
	public int multiplication(int num1, int num2) {
		
		return num1*num2;
	}

	@Override
	public int division(int num1, int num2) {

		return (num1/num2);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(addition(3,8));
		
		
	}

}
