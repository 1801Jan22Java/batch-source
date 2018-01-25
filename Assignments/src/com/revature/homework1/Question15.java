package com.revature.homework1;

import java.util.Random;

/*
 * Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division.  
 * Create a class that implements this interface and provides appropriate 
 * functionality to carry out the required operations. Hard code two operands 
 * in a test class having a main method that calls the implementing class.
 */

//This is the test class for the class that implements an interface
public class Question15 {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		Random rand = new Random();
		
		double x;
		double y;
		
		//String.format("%f + %f = %f", x, y, calc.add(x, y))
		
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		System.out.println(String.format("%.2f + %.2f = %.2f", x, y, calc.add(x, y)));
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		System.out.println(String.format("%.2f + %.2f = %.2f", x, y, calc.add(x, y)));
		
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		System.out.println(String.format("%.2f - %.2f = %.2f", x, y, calc.subtract(x, y)));
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		System.out.println(String.format("%.2f - %.2f = %.2f", x, y, calc.subtract(x, y)));
		
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		System.out.println(String.format("%.2f * %.2f = %.2f", x, y, calc.multiply(x, y)));
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		System.out.println(String.format("%.2f * %.2f = %.2f", x, y, calc.multiply(x, y)));
		
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		
		while(y == 0.0) {
			y = rand.nextInt(100);
		}
		
		System.out.println(String.format("%.2f / %.2f = %.2f", x, y, calc.divide(x, y)));
		x = rand.nextInt(100);
		y = rand.nextInt(100);
		
		while(y == 0.0) {
			y = rand.nextInt(100);
		}
		
		System.out.println(String.format("%.2f / %.2f = %.2f", x, y, calc.divide(x, y)));
		
		
		
	}

}
