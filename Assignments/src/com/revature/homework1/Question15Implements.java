package com.revature.homework1;

public class Question15Implements implements Question15Interface {
	// declare reference variables
	double a;
	double b;

	// no-arg and overloaded contructors
	public Question15Implements() {
		super();
	}

	
	public Question15Implements(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}
	// overriden methods implementing interface methods
	@Override
	public double add() {
		return a + b;
	}

	@Override
	public double subtract() {
		return a - b;
	}

	@Override
	public double multiply() {
		return a * b;
	}

	@Override
	public double divide(double a, double b) {
		return a/b;
	}

	// getters and setters
	public double getA() {
		return a;
	}


	public void setA(double a) {
		this.a = a;
	}


	public double getB() {
		return b;
	}


	public void setB(double b) {
		this.b = b;
	}
	
	

}
