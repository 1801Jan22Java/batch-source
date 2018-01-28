package com.revature.homework1;

public class Question1 {

	public static void main(String [] args) {
	
	//Create an array of the desired integers to be swapped
	int[] theArray = new int[] {1,0,5,6,3,2,3,7,9,8,4};
	//call to swap function
	theSwap(theArray, 11);
	//print the array
	printArray(theArray, 11);
	}
	//function to swap the numbers 
	public static void theSwap(int arr[], int n){
		int i, j, temp;
		boolean swapped;
		//for loop to check the next number is larger
		//and switches it if true
		for(i=0; i<n-1; i++)
		{
			swapped = false;
			for(j=0; j < n-i-1; j++)
			{
				if(arr[j] > arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			if(swapped == false)
				break;
		}
	}
	
	//function to print the array of numbers
	static void printArray(int arr[], int size)
	{
		int i;
		for (i=0; i < size; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
}
