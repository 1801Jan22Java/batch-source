package com.revature.homework1;
/*
 * 
Q13. Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
    0
    1 0
    1 0 1
    0 1 0 1
*/
public class Question13 {
	
	public static void main(String [] args)
	{
		
		for(int i=0;i<4;i++)
		{
			
			for(int j=0;j<4;j++)
			{
				System.out.print("0 ");
			}
			System.out.println();
		}
	}
}
