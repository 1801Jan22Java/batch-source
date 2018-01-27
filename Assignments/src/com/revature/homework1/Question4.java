package com.revature.homework1;

public class Question4 {
	
	public static double computeFractionPart(double m) {
		
		double afterDecimal = m % 1;
		
		
		
		
		return afterDecimal;
		
		
		
	}
	
	public static double computeFactorial(double n) {
		
		double computedFactorial = 1.0;
		
		
		
		if(n>1) {
		for(int i = 1; i< n+1; i++) {
			computedFactorial = computedFactorial *i;
			
		}}
		if(n<0) {
			n = n * -1;
			for(int i = 1; i< n+1; i++) {
				computedFactorial = computedFactorial * i;
			
			
		} computedFactorial = computedFactorial * -1;
			}
		
		return computedFactorial;
		
		
	}
	
	public static void main(String[] args) {
		double testNumber = 7.4;
		double factorial = computeFactorial(testNumber);
		System.out.println(factorial);
	}
	
	

}
