package com.revature.homework1;

import com.revature.homework1Resource.Question11Resource;

public class Question11 {

	//Q11. Write a program that would access two float-variables from a class that exists in another package. 
	//Note, you will need to create two packages to demonstrate the solution.
	public static void main(String[] args) {
		
		// decimal is 'double' by default. float should have 'F' at the end to tell compiler it's float.
		float f1 = 1444.333F;		
		float f2 = 3.14F;
		
		setFloat(f1, f2);
		System.out.println(getFloat());
	}
	
	public static void setFloat (Float f1, Float f2) {
		
		Question11Resource q11Rs = new Question11Resource(f1, f2);		// 'set' method can be used too, 
		System.out.println(q11Rs.toString());							// but constructor saves line than 'set' method.
		
	}
	
	public static Question11Resource getFloat() {
		
		return new Question11Resource();
	}
}
