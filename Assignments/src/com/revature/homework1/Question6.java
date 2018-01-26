package com.revature.homework1;
/*
 * 
 */
public class Question6 {
	/*
	 * This method checks to see if a number is even.
	 * Returns a true if it is even and a false if it is odd
	 */
	private static boolean isEven(int num)
	{
		if ((num&1) == 0)			//check last bit for a 0
		{
			return true;			// number is even
		}
		return false;				//the number is false
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 14;
		if (isEven(number))
		{
			System.out.println("The number " + number + " is even");
		}
		else	
		{
			System.out.println("The number " + number + " is odd");
		}
	}

}
