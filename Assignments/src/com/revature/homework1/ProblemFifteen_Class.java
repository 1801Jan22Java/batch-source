package com.revature.homework1;

public class ProblemFifteen_Class implements ProblemFifteen_Interface {

	@Override
	public int addition(int one, int two) {
		return one + two;
	}

	@Override
	public int subtraction(int one, int two) {
		return one - two;
	}

	@Override
	public int multiplication(int one, int two) {
		return one * two;
	}

	@Override
	public int division(int one, int two) {
		return one % two;
	}

}
