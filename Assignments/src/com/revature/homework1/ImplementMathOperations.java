package com.revature.homework1;

public class ImplementMathOperations implements MathOperations {
	
	
	@Override
	public Double addition(double n1, double n2) {
		return n1 + n2;
	}
	@Override
	public Double subtraction(double n1, double n2) {
		return n1 - n2;
	}
	@Override
	public Double division(double n1, double n2) {
		return n1/n2;
	}
	@Override
	public Double multiplication(double n1, double n2) {
		return n1*n2;
	}

}
