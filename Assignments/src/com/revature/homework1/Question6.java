package com.revature.homework1;

public class Question6 {
	
	public static boolean isEven(int n){
		Double rationalNumber = (double) n /2;
		 Integer integerPart = rationalNumber.intValue();
		 double decimalPart = rationalNumber - integerPart;
		 
		 
		if(decimalPart != 0) {
			System.out.println(n + " is not even");
			return false;
		}else 
			System.out.println(n + " is even");
			return true;
		
		
	}

	public static void main(String[] args) {
	
		isEven(0);
		isEven(24);
		isEven(-59);


	}

}
