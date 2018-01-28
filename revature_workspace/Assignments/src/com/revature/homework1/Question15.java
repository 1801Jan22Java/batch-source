package com.revature.homework1;
/*
 * Q15. Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division.  
 * Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
 * Hard code two operands in a test class having a main method that calls the implementing class.
 * */

/*Interface Operatable has four public abstract methods that are fleshed out by the implementing class */
interface Operatable  
{
	//public abstract implied
	double add(double a, double b);
	//spelling out 'public and abstract'
	public abstract double subtract(double a, double b);
	//just spelling out abstract - still public
	abstract double multiply(double a, double b);
	//public abstract implied
	double divide(double a, double b);
	
}

/*class Operation (default access) implements Operatable and implements the four methods, add, subtract, multiply, and dvidide*/
class Operation implements Operatable {

	/*
	 * add returns double
	 * takes in doubles a and b and adds them.
	 * @param doubles a, b
	 * @return a+b
	 * */
	@Override
	public double add(double a, double b) {
		
		return a+b;
	}

	/*
	 * subtract returns double
	 * takes in doubles a and b and subtracts b from a.
	 * @param doubles a, b
	 * @return a-b
	 * */
	@Override
	public double subtract(double a, double b) {
		return a-b;
	}
	
	/*
	 * subtract returns double
	 * takes in doubles a and b and multiplies a by b
	 * @param doubles a, b
	 * @return a*b
	 * */
	@Override
	public double multiply(double a, double b) {
		return a*b;
	}

	/*
	 * subtract returns double
	 * takes in doubles a and b and divides a by b.
	 * @param doubles a, b
	 * @return a/b
	 * */
	@Override
	public double divide(double a, double b) {
		return a/b;
	}
}

public class Question15 {
	
	public static void main(String [] args)
	{
		Operation operator = new Operation();
		double addition=operator.add(5,6);
		double subtraction=operator.subtract(6,14);
		double division=operator.divide(8,3.2);
		double multiplication=operator.multiply(9.4,7);
		System.out.println("Implementing methods in Class Operation from interface Operatable");
		System.out.println("Addition: 5+6="+addition);
		System.out.println("Subtraction: 6-14="+subtraction);
		System.out.println("Multiplication: 8*3.2="+multiplication);
		System.out.println("Division: 9.4/7="+division);
		
	}

}
