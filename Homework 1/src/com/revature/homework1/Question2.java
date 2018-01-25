//Done!
package com.revature.homework1;

public class Question2 {
	public static void fibonacci() {
		int firstNum = 1;		//The first number of the sequence
		int secondNum = 1;		//The second number of the sequence
		int fibonacciMax = 25;	//The index of the last Fibonacci number to be displayed
		System.out.print("The first " + fibonacciMax + " Fibonacci numbers are: ");
		System.out.print(firstNum + " " + secondNum + " ");
		
		//Swap between replacing the first and second variables with the newest values
		boolean firstNumReady = true;
		
		for(int i = 2; i < fibonacciMax; i++) {
			//If firstNum is to be replaced this time
			if(firstNumReady) {
				firstNumReady = false;				//Make sure secondNum gets replaced next
				firstNum += secondNum;				//Add secondNum to firstNum's current value
				System.out.print(firstNum + " ");	//Print out firstNum's value
			}
			else {
				firstNumReady = true;				//Make sure firstNum gets replaced next
				secondNum += firstNum;				//Add firstNum to secondNum's current value
				System.out.print(secondNum + " ");	//Print out secondNum's value
			}
		}
	}
	
	public static void main(String[] args) {
		Question2.fibonacci();
	}
}
