package com.revature.homework1;

public class Question13 {

	public static void main(String[] args) {

			//for loop to output the remainder of odd and even
			//numbers and creates a new line when the inner for loops
			//initializing variable is greater than the outer foor loop 
			//int variable
			for(int i = 1; i <= 4; i++)
			{
				for(int j = 1;j <= i; j++)
				{
					System.out.print(((i + j) %2) + " ");
				}
				System.out.print("\n");
			}
		
	}

}
