package com.revature.homework1;

public class Question15 implements Calculatable {
	private double a;
	private double b;
	// constructor accepting two arguments for private fields
	public Question15(double number1, double number2) {
		super();
		a = number1;
		b = number2;
	}
	// adds two numbers
	@Override
	public double addition() {
		return a+b;
	}
	// subtracts b from a
	@Override
	public double subtraction() {
		return a-b;
	}
	// multiply a by b
	@Override
	public double multiplication() {
		return a*b;
	}
	// divides a by b
	@Override
	public double division() {
		return a/b;
	}
}
