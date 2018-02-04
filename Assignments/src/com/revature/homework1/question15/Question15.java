package question15;

// Q15. Write a program that defines an interface having the following methods: addition,
// subtraction, multiplication, and division. Create a class that implements this interface and
// provides appropriate functionality to carry out the required operations. Hard code two
// operands in a test class having a main method that calls the implementing class.
// Created by: KP Saini

public class Question15 implements BasicMathFunctions {

	public static void main(String[] args) {
		
		// construct a Question15 object with the default constructor
		Question15 question15 = new Question15();	
		
		// hard-coded operands
		double operand1 = 10.0;
		double operand2 = 5.0;
		
		// print messages to the console
		System.out.println("The first operand is " + operand1);
		System.out.println("The second operand is " + operand2);

		System.out.println("\nAddition: ");			// invoke the addition method
		System.out.println(question15.addition(operand1, operand2));
		
		System.out.println("\nSubtraction: ");		// invoke the subtraction method
		System.out.println(question15.subtraction(operand1, operand2));
		
		System.out.println("\nMultiplication: ");	// invoke the multiplication method
		System.out.println(question15.multiplication(operand1, operand2));
		
		System.out.println("\nDivision");			// invoke the division method
		System.out.println(question15.division(operand1, operand2));
	}
	
	@Override	// implementation for addition method
	public double addition(double operand1, double operand2) {
		System.out.println(operand1 + " + " + operand2 + " is equal to: ");
		return operand1 + operand2;
	}

	@Override	// implementation for subtraction method
	public double subtraction(double operand1, double operand2) {
		System.out.println(operand1 + " - " + operand2 + " is equal to: ");
		return operand1 - operand2;
	}

	@Override	// implementation for multiplication method
	public double multiplication(double operand1, double operand2) {
		System.out.println(operand1 + " * " + operand2 + " is equal to: ");
		return operand1 * operand2;
	}

	@Override	// implementation for division method
	public double division(double operand1, double operand2) {
		System.out.println(operand1 + " / " + operand2 + " is equal to: ");
		return operand1 / operand2;
	}
}
