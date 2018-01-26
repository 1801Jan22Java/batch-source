package com.revature.homework1;

public class BasicCalculator implements Operations{

	@Override
	public float add(float a, float b) {
		
		return a+b;
	}

	@Override
	public float subtract(float a, float b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public float multiply(float a, float b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public float divide(float a, float b) {
		try {
			if(b<0) {
				throw new ArithmeticException();
			}
			return a/b;
		} catch (Exception e) {
			System.out.println("Cannot divide by 0.");
		}
		return 0;
	}

}
