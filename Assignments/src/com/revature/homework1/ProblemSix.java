package com.revature.homework1;

public class ProblemSix {
	
	public static void evenNumbers(int number) {
		boolean finished_looping = false;
		double new_number = number;
		
		while(!finished_looping) {
			if(new_number <= 1) {
				finished_looping = true;
				break;
			}
			else {
				new_number = new_number/2;
			}
		}
		
		if(new_number<1) {
			System.out.print("Odd");
		}
		else {
			System.out.print("even");
		}
	}
	public static void main(String args[]) {
		evenNumbers(7);
	}

}
