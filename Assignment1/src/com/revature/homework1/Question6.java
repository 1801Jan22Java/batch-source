package com.revature.homework1;

public class Question6 
{
	public static boolean isEven(int x)
	{
		boolean isEven = true;
		
		//Odd integers do not divide evenly.
		//If you divide by two, the remainder is cut off.
		//if you multiply the number by 2, and add 2, you should be 1 more than the original number.
		//if so, then the number is odd.
		if((x/2)*2+2 == x+1)
			isEven = false;
		return isEven;
	}
}
