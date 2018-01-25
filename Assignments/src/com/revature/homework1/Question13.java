package com.revature.homework1;
/*
 *Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print
 *statements to accomplish this.
 * 0
 * 1 0
 * 1 0 1
 * 0 1 0 1
 */
public class Question13 
{
	public static int numLetter(String str, char c)
	{
		int count = 0;
		for(int i  = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == c)
				count++;
		}
		return count;
	}
	public static void main(String args[])
	{
		String str = "0";
		int j = 0;
		do
		{	
			//if the number of 0's is less than or equal to the number of 1's
			//add another 1 where the isn't one
			System.out.println(str);
			if(numLetter(str,'0') >= numLetter(str,'1'))
			{
				if(str.charAt(0)=='0')
				{
					//System.out.println(str.charAt(str.length()-1)=='1');
					str = "1".concat(str);
				}
				else
				{
					
					str = str.concat("1");
				}
			}
			else
			{
				str = "0"+str;
			}
			
			j++;
		}
		while(j<4);
	}
}
