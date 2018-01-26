package com.revature.calculator;

import org.junit.Test;

//Run -> Run As -> JUnit Test
public class CalculatorTest {

	//This test passes if a RuntimeException IS thrown
	@Test(expected=RuntimeException.class)
	public final void moreThanTwoThrowsException() {
		Calculator.add("1,2,3");
	}
}
