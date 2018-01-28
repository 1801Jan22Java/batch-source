package com.revature.homework1;

public class Question2 {

	public static void main(String[] args) {
	
		int f1 = 0, f2 = 1, f3 = 0;
		
		//start with printing 0 and 1
		System.out.print(f1 + ", " + f2 + ", ");
		
		
		//for loop uses a sum variable to add to create the next number in the sequence
		for (int i = 2; i < 25; i++)
		{
			//take the two previous numbers and add them f3 which is always the next number
			//and send it to the console
			f3 = f2 + f1;
			System.out.print( f3 + ", ");
			f1 = f2;
			f2 = f3;
			
		}
		
		

	}

}
