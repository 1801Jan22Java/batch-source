package com.revature.homework1;

public class Question6 {
	public static String isEven(int number) {
		// when dividing integers, Java uses integer division and ignores the remainder
		// the lost remainder will cause the result, when doubled, to be short of the original
		if ((number/2)*2 == number) {
			// case 1: doubled result equals original number -- indicates even
			return "even";
		} else {
			// case 2: doubled result not equal to original number -- indicates odd
			return "odd";
		}
	}

}
