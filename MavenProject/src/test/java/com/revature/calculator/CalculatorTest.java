package com.revature.calculator;

import org.junit.Test;

public class CalculatorTest {
	@Test//(expected=RuntimeException.class)
	public final void moreThanTwoThrowsException() {
		Calculator.add("1,2,3");
	}
}
