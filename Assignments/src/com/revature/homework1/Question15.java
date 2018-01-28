package com.revature.homework1;

/**
 * Created by: Jeffrey Rubi Date: 27 January 2018 
 * Write a program that defines an interface having the following methods: addition, subtraction,
 * multiplication, and division. Create a class that implements this interface and provides appropriate 
 * functionality to carry out the required operations. Hard code two operands in a test class having a main 
 * method that calls the implementing class.
 */

public class Question15 {

	public static void main(String[] args) {
		// instantiate the implemented class
		Question15Implements calc = new Question15Implements(1, 2);
		
		// display results, 1, 2 is hard coded for test.
		System.out.println("Adding 1 + 2... = " + calc.add());
		System.out.println("Subtracting 1 - 2...= " + calc.subtract());
		System.out.println("Multiplying 1 x 2...= " + calc.multiply());
		System.out.println("Dividing 1 / 3...= " + calc.divide(1, 3));
		
	} // end main()

} // end class

