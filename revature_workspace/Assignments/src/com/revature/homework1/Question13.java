package com.revature.homework1;
/*
 * 
Q13. Display the triangle on the console as follows using any type of loop.  
Do NOT use a simple group of print statements to accomplish this.
    0  // length is odd j is odd
    1 0  //length is even j is odd, then j is even
    1 0 1 //length is odd, j is odd, then js is even, then j is odd
    0 1 0 1 //length is even, 
*/
public class Question13 {
	
	public static void main(String [] args)
	{
		int length = 0;
		for(int i=0;i<=4;i++)
		{	
			for(int j=0;j<length;j++)
			{
				
				if(length%2!=0)
				{
					System.out.print("0 ");
				}
				else if (length %2==0 && j%2!=0)
				{
					
					System.out.print("1 ");
				}
				else
				{
					System.out.print("0 ");
				}
				
			}
			length++;
			System.out.println();
		}
		
	}
}
