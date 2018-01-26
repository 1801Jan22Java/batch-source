package com.revature.homework1;

public class Calculator implements Operator {
	
	//add the two double parameters and return the result
	public void addition(double num1, double num2)
	{
		System.out.println("Adding " + num1 +" and "+num2);
		System.out.println("Result = " + (num1+num2));
	}

	//subtract the two double parameters and return the result
	public void subtraction(double num1, double num2) {
		
		System.out.println("Subtracting " + num1 +" and "+num2);
		System.out.println("Result = " + (num1-num2));
	}


	//multiply the two double parameters and return the result
	public void multiplication(double num1, double num2) {
		
		System.out.println("Multiplying " + num1 +" and "+num2);
		System.out.println("Result = " + (num1*num2));
	}

	//divide the two double parameters and return the result
	public void division(double num1, double num2) {
		
		System.out.println("Dividing " + num1 +" and "+num2);
		System.out.println("Result = " + (num1/num2));
	}
	

}
