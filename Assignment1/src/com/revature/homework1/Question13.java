package com.revature.homework1;

public class Question13
{
	public static void displayNumTriangle()
	{
		int curr = 2;
		for(int i = 1; i <= 4; i++)
		{	
			for(int j = i; j > 0; j--)
			{
				if(curr%2 == 0)
					System.out.print(0 + " ");
				else
					System.out.print(1 + " ");
				curr++;
			}
			System.out.println();
		}
	}
}
