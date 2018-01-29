package com.revature.homework1;

interface Arithmetic{
	
	int addition(int op1, int op2);
	int subtraction(int op1, int op2);
	int multiplication(int op1, int op2);
	int division(int op1, int op2);
}

class Question15 implements Arithmetic{
	
	public static void main(String[] args) {
	int op1 = 8;
	int op2 = 15;
	Question15 testObj = new Question15();
	System.out.println(testObj.addition(op1,op2));
	System.out.println(testObj.subtraction(op1,op2));
	System.out.println(testObj.multiplication(op1,op2));
	System.out.println(testObj.division(op1,op2));
	}
	public int addition(int op1, int op2) {
		return op1 + op2;
	}
	
	public int subtraction(int op1, int op2) {
		return op1 - op2;
	}
	
	public int multiplication(int op1, int op2) {
        return op1 * op2;
	}
	
	public int division(int op1, int op2) throws ArithmeticException{
		int result=0;
		try {
			result = op1 / op2;
		}catch(ArithmeticException e){
			System.exit(1);
		}
		return result;
	}
}


