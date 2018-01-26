package com.revature.homework1;

public class Question4 {

	public Question4() {
		super();
	}
	
	//Using a for-loop, start at given value and multiply it by the value before it
	public static void factorial(int num) {
		int sum = num;
		for(int i = num-1; i > 1; i--) {
			sum = sum * i;
		}
		System.out.println(sum);
	}
}
