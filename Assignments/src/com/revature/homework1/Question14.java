package com.revature.homework1;

import java.util.Arrays;
import java.util.Calendar;

public class Question14 {

	public static void main(String[] args) {

		//call each of the cases
		
		System.out.println("case 1:");
		switchCall(1);
		System.out.println("case 2:");
		switchCall(2);
		System.out.println("case 3:");
		switchCall(3);
		
	}
	
	@SuppressWarnings("deprecation")
	public static void switchCall(int n) {
		
		String s = "I am learning Core Java";
		
		Calendar c = Calendar.getInstance();
		
		double d = 16;
		
		switch(n) {
		
		case 1: {
			System.out.println("the square root of 16 is "+Math.sqrt(d));
			break;
		}
		
		case 2: {
			System.out.println("today is "+c.get(Calendar.MONTH)+1+"/"+c.get(Calendar.DATE));
			break;
		}
		
		case 3: {
			System.out.println(Arrays.toString(s.split(" ")));
			break;
		}
		
		}
	}
}
