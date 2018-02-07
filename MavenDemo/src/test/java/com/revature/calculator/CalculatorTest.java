package com.revature.calculator;

import org.junit.Test;

public class CalculatorTest {

	@Test (expected=RuntimeException.class)
	public final void moreThanTwoThrowException() {
		Calculator.add("1,2,3");
	}
}
