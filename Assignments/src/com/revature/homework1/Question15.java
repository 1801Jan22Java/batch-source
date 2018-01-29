package com.revature.homework1;

public class Question15 {
	


	
	private static void tester() {
		
		// creates new instance of MathSubClass and performes examples of functionality
		MathSubClass fun = new MathSubClass();
		System.out.println(fun.addition(13, 11));
		System.out.println(fun.subtraction(13, 11));
		System.out.println(fun.multiplication(300, 10));
		System.out.println(fun.division(300, 10));
		
	}
	
	public static void main(String args[]) {
		tester();
		
		
	}
}
	
	 class MathSubClass implements Question15Interface {
		

		
		@Override
		public int addition(int num1, int num2) {
			return (num1 + num2);
		}

		@Override
		public int subtraction(int num1, int num2) {
			return (num1 - num2) ;
		}

		@Override
		public int multiplication(int num1, int num2) {
			
			return num1*num2;
		}

		@Override
		public int division(int num1, int num2) {

			return (num1/num2);
		}



	}
	
	



