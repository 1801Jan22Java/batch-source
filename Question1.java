package com.revature.homework1;

public class Question1 {

	//implement the bubble sort 
	public void bubbleSort(int num[]) {
		int n = num.length;
		for(int i=0;i<num.length;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(num[j] > num[j+1]) {
					//swap and num[i]
					int temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
			}
		}
	}
	 //Print the array
	public void printArray(int num[]) {
		int n = num.length;
		for(int i=0;i<n;++i) {
			System.out.print(num[i] + " ");
				System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Question1 q1 = new Question1();
		int num[] =  {1,0,5,6,3,2,3,7,9,8,4};
		q1.bubbleSort(num);
		System.out.println("The bubble sorted array");
		q1.printArray(num);
		
	}
}
