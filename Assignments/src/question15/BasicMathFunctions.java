package question15;

// Q15. Write a program that defines an interface having the following methods: addition,
// subtraction, multiplication, and division. Create a class that implements this interface and
// provides appropriate functionality to carry out the required operations. Hard code two
// operands in a test class having a main method that calls the implementing class.
public interface BasicMathFunctions {

	// methods with double input parameters and a double return type
	double addition(double operand1, double operand2);
	double subtraction(double operand1, double operand2);
	double multiplication(double operand1, double operand2);
	double division(double operand1, double operand2);
	
}
