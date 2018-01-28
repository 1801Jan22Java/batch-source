package com.revature.homework1;

/*
 * Find the minimum of two numbers using ternary operators
 */
public class Question10 {
	
	private int num1; 
	private int num2;
	
	public Question10(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int doThing() {
		return (num1 < num2) ? num1 : num2;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	

}
