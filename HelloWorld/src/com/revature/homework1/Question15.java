package com.revature.homework1;

public class Question15 {

	/*
	 * Gin / Q15. Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  
	 * Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
	 * Hard code two operands in a test class having a main method that calls the implementing class.			 
	 */
	static final double no1 = 4.5;
	static final double no2 = 2.6;
	
	public static void main(String[] args) {
	
		BasicCalculator cal = new BasicCalculator(no1, no2);
		System.out.println(cal.multiplication());
		
	}
	
	interface Calculator {

		Double addition();
		Double subtraction();
		Double multiplication();
		Double division();
	}
	
	static class BasicCalculator implements Calculator {

		private Double firstNo;
		private Double secondNo;
		
		public BasicCalculator() {
			super();
		}
		
		public BasicCalculator(Double firstNo, Double secondNo) {
			super();
			this.firstNo = firstNo;
			this.secondNo = secondNo;
		}

		@Override
		public Double addition() {
			return firstNo + secondNo;
		}

		@Override
		public Double subtraction() {
			return firstNo - secondNo;
		}

		@Override
		public Double multiplication() {
			return firstNo * secondNo;
		}

		@Override
		public Double division() {
			return firstNo / secondNo;
		}

	}

}
