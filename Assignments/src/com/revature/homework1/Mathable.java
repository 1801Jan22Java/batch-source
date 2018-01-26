package com.revature.homework1;

/**
 * interface for implementing math operations
 * 
 * @author Ahmed Awwad
 *
 */
public interface Mathable {
	
	/**
	 * Adds two numbers
	 * 
	 * @param a first number
	 * @param b second number
	 * @return Result of addition
	 */
	double add(double a, double b);
	
	/**
	 * Subtracts two numbers
	 * 
	 * @param a first number
	 * @param b second number
	 * @return Result of Subtraction
	 */
	double subtract(double a, double b);
	
	/**
	 * Multiplies two numbers
	 * 
	 * @param a first number
	 * @param b second number
	 * @return Result of multiplication
	 */
	double multiply(double a, double b);
	
	/**
	 * Divides two numbers
	 * 
	 * @param a Numerator
	 * @param b Denominator
	 * @return Result of division
	 */
	double divide(double a, double b);
	
}