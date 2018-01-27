package com.revature.homework1;


/*
 * Q1. Perform a bubble sort on the 
 * following integer array:  
 * 1,0,5,6,3,2,3,7,9,8,4

 * */
public class Question1 {
	
	
	/*Bubble sort method
	 * Uses bubble sort to sort numbers in 
	 * array
	 * Uses nested for loop to repeatedly iterate through array until 
	 * items are swapped into order
	 * @param  arrray (int[] )
	 * @return void
	 * 
	*/
	public void bubbleSort(int[] array)
	{
		for(int i =0;i<array.length;i++)
		{
			for(int j =0;j<array.length-1;j++)
			{
				//Swap if int at lower index is greater than int at higher index.
				if(array[j]>array[j+1])
				{
					int temp = array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		
	}
	
}
