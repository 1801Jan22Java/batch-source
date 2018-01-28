package com.revature.homework1;

/*
 * Write a program that defines an interface having the following methods: addition,
subtraction, multiplication, and division. Create a class that implements this interface and
provides appropriate functionality to carry out the required operations. Hard code two
operands in a test class having a main method that calls the implementing class.

 */
public class Question15 implements Question15a{
	
	public Question15(long num1, long num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	private long num1;
	private long num2;

	@Override
	public long addition() {
		
		return num1 + num2;
	}

	@Override
	public long subtraction() {
		
		return num1 - num2;
	}

	@Override
	public long multiplication() {
		
		return num1 * num2;
	}

	@Override
	public long division() {
		
		return num1 / num2;
	}

	public long getNum1() {
		
		return num1;
	}

	public void setNum1(long num1) {
		this.num1 = num1;
	}

	public long getNum2() {
		return num2;
	}

	public void setNum2(long num2) {
		this.num2 = num2;
	}
	
}
