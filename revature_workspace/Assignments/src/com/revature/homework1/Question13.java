package com.revature.homework1;
/*
 * 
Q13. Display the triangle on the console as follows using any type of loop.  
Do NOT use a simple group of print statements to accomplish this.
    0  // length is odd j is odd and 0
    1 0  //length is even, when j is even, j is 0, when j is odd, j is 1
    1 0 1 //length is odd, j is odd, then j is even, then j is odd
    0 1 0 1 //length is even, 
 */
public class Question13 {

	public void displayTriangle(){
		int length = 0;
		for(int i=0;i<=4;i++)
		{	
			for(int j=0;j<length;j++)
			{

				if(length==1)
				{
					System.out.print("0 ");
				}
				else if (length>1 && length<4)	
				{
					if(j%2==0){
						System.out.print("1 ");}
					else{
						System.out.print("0 ");
					}
				}
				else
				{
					if(j%2==0)
					{
						System.out.print("0 ");
					}
					else
					{
						System.out.print("1 ");
					}
				}
			}
			length++;
			System.out.println();
		}
	}
}
