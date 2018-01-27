package com.revature.homework1;
//James Whitten

public class Question6 {

	//Determines if an integer is even or odd
	boolean isEven(int num)
	{
		//If negative convert to positive for the check
		if (num < 0)
			num = Math.abs(num);
		
		//If the number above is truncated down to this number it must be even
		if ((num/2)==((num+1)/2))
				return true;
		return false;
	}
	
	//Our main
	public static void main(String[] args)
	{
		//Creating the Question6 object
		Question6 q6 = new Question6();
		//Test cases
		System.out.println(q6.isEven(4));
		System.out.println(q6.isEven(5));
		System.out.println(q6.isEven(-6));
		System.out.println(q6.isEven(-7));

	}
	

	
}
