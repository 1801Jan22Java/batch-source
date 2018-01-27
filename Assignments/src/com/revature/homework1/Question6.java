package com.revature.homework1;

public class Question6 {
	
	// idk if this is the way i should be doing it?????
	
	public static boolean evenOrOdd(int num) {
		
		// subtract from the value until it is zero or less than zero
		int number = num;
		while (number > 0) {
			number -= 2;
		}
		
		// depending on the value, return the appropriate boolean
		if (number == 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(evenOrOdd(27));
	}

}
