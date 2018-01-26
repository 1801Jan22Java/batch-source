package com.revature.homework1;

/**
 * 
 * @author Nabeela Hassan
 * Performs bubble sort on an integer array
 *
 */
public class Question1 {
	static int numbers[] = new int[] {1,0,5,6,3,2,3,7,9,8,4};						//instantiate the array
	
	/*
	 * This method sorts the given array using bubble sort
	 */
	public static void bubbleSort()
	{
		
		for (int i = 0; i<numbers.length-1; i++)
		{
			for(int j = 0; j<numbers.length-1; j++)
			{
				if(numbers[j]>numbers[j+1])									//compare adjacent values
				{
					swap(j,j+1);
				}
			}
			
		}//end of outer loop
	}
	public static void swap(int index1, int index2)
	{
		int temp;
		temp = numbers[index1];
		numbers[index1] = numbers[index2];
		numbers[index2] = temp;
	}
	
	public static void main(String args[])
	{
		System.out.print("Unsorted String: ");							//printing the list before sorting
		for (int i = 0; i<numbers.length; i++)						
		{
			System.out.print(numbers[i] + " ");
		}
		System.out.println();											//new line
		
		bubbleSort();
		
		System.out.print("Sorted String: ");							//printing the list before sorting
		for (int i = 0; i<numbers.length; i++)						
		{
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}

}
