package com.revature.homework1;

public class Question4 {

	public static double computeFactorial(double n) {
		
		double computedFactorial = 1.0;

		if(n>1) {
		for(int i = 1; i< n+1; i++) {
			computedFactorial = computedFactorial *i;
			
		}}
		// if factorial is less than 0 uses logic above but multiplies by negative factor
		if(n<0) {
			n = n * -1;
			for(int i = 1; i< n+1; i++) {
				computedFactorial = computedFactorial * i;
			
			
		} computedFactorial = computedFactorial * -1;
			}
		
		return computedFactorial;
		
		
	}
	
	public static void main(String[] args) {
		double testNumber = 7.0;
		double factorial = computeFactorial(testNumber);
		System.out.println(factorial);
	}
	
	

}
