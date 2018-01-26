package com.revature.homework1;

public class Question15 implements Operation {
	
	
	
	public Question15() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question15(double firstNum, double secondNum) {
		super();
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}

	private double firstNum;
	private double secondNum;
	
	@Override
	public Double addition() {
		return firstNum + secondNum;
	}

	@Override
	public Double multiplication() {
		return firstNum*secondNum;
	}

	@Override
	public Double division() {
		return firstNum/secondNum;
	}

	@Override
	public Double subtraction() {
		return firstNum-secondNum;
	}

	
}
