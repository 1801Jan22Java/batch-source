package com.revature.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	
	@Test(expected=RuntimeException.class)
	public final void moreThanTwoThrowsException(){
		Calculator.add("1,2,3");
	}

	@Test
	public final void twoNumbersReturnsSum() {
		int sum = Calculator.add("23,79");
		assertEquals(102, sum);
	}

	@Test
	public final void emptyStringReturnsZero() {
		int sum = Calculator.add("");
		assertEquals(0, sum);
	}

}
