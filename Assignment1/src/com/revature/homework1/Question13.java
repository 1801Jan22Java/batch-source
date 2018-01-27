package com.revature.homework1;

public class Question13
{
	public static void displayNumTriangle()
	{
		//used for alternating between 0 and 1
		int curr = 2;
		//the triangle has 4 levels
		for(int i = 1; i <= 4; i++)
		{	
			//each level has digits corresponding to the number of the level
			for(int j = i; j > 0; j--)
			{
				//if curr is divisble by 2, print 0,
				if(curr%2 == 0)
					System.out.print(0 + " ");
				else
				//otherwise, print 1
					System.out.print(1 + " ");
				//increment the value 
				curr++;
			}
			//start a new line.
			System.out.println();
		}
	}
}
