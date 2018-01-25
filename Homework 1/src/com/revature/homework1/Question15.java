//Done!
package com.revature.homework1;

//This default class implements the interface Question15Interface,
//providing functionality for each arithmetic function
class Operations implements Question15Interface {

	@Override
	public double addition(double first, double second) {
		return first + second;
	}

	@Override
	public double subtraction(double first, double second) {
		return first - second;
	}

	@Override
	public double multiplication(double first, double second) {
		return first * second;
	}

	@Override
	public double division(double first, double second) {
		return first / second;
	}
	
}

public class Question15{
	public static void main(String[] args) {
		//HARD CODED OPERANDS HERE
		double operand1 = 5;
		double operand2 = 7;
		
		//Create a new Operations object and use it to run each implemented method on the
		//hard-coded operands
		Operations o = new Operations();
		System.out.println(operand1 + " + " + operand2 + " = " + o.addition(operand1, operand2));
		System.out.println(operand1 + " - " + operand2 + " = " + o.subtraction(operand1, operand2));
		System.out.println(operand1 + " * " + operand2 + " = " + o.multiplication(operand1, operand2));
		System.out.println(operand1 + " / " + operand2 + " = " + o.division(operand1, operand2));
	}
}
