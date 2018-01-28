package com.revature.calculator;

import org.junit.Test;

public class CalculatorTest {

	// expecting an exception to be thrown, if exception is thrown then test passes
	@Test(expected=RuntimeException.class)
	public final void moreThanTwoThrowsException() {
		Calculator.add("1, 2, 3");
	}
	
	// check GitHub for rest of the tests
}
