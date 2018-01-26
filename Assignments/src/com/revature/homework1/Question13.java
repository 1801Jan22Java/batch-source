package com.revature.homework1;

public class Question13 {

	//prints out alternating 0s and 1s in the shape of a triangle
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++)
		{
			System.out.print(" "+ i%2); 				//the modulus of the current number results in either 0 or 1 
			switch (i) {								//switch based on i
			case 0: System.out.println(); break;		//print a new line after 1st iteration
			case 2: System.out.println(); break;		//print a new line after 3rd iteration
			case 5: System.out.println(); break;		//print a new line after 6th iteration
			}
			
		}
		

	}

}
