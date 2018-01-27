package com.revature.homework1;
//James Whitten
//Due: 1-29-18


public class Question1 {

	//Does a bubbleSort on an array
	void bubbleSort(int ourArray[])
	{
		
		//We swap j each time we find a number smaller than it as we go down the array
		for (int i = 0; i < ourArray.length - 1 ; i++)
		{
			//We do not need to check array values that are before j
			for (int j = 0; j < ourArray.length - i - 1; j++)
			{
				//If the next value is less than j we shall do a swap then move on down the array
				if (ourArray[j] > ourArray[j+1])
				{
					//Swapping the values by first storing the j value in a temp variable then setting j to j+1 and then setting j+1 to temp
					int temp = ourArray[j];
					ourArray[j] = ourArray[j+1];
					ourArray[j+1] = temp;
				}
			}
			
		}
	}
	
	//Prints our array
	void printArray(int ourArray[])
	{
		//++i is used so the array does not increment out of bounds at the end
		for (int i = 0; i < ourArray.length; ++i)
		{
			System.out.print(ourArray[i] + " ");
		}
		//Go to the next line
		System.out.println();
	}
	
	//Our main
	public static void main(String[] args) {
		
		//Creating our Question1 object
		Question1 q1 = new Question1();
		//Our array used
		int ourArray[] = {1,0,5,6,3,2,3,7,9,8,4};
		//Prints the unsorted array
		q1.printArray(ourArray);
		//Use bubbleSort on the array
		q1.bubbleSort(ourArray);
		//Prints out the sorted array
		q1.printArray(ourArray);
		
		
	}
	
	
}
