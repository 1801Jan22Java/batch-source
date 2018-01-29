package com.revature.homework1;

class Question1{
	
	static int[] source = {1,0,5,6,3,2,3,7,9,8,4};
	
	static void swap(int left, int right, int[] source){
		int temp = source[left];
		source[left] = source[right];
		source[right] = temp;
	}
	
	static void bubbleSort(int[] target) {
		for (int i = 0; i < target.length - 1; i++) {
			for (int j = i + 1; j < target.length; j++) {
				if (target[i] > target[j])
					swap(i, j, target);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] source = {1,0,5,6,3,2,3,7,9,8,4};
		bubbleSort(source);
		//for (int i = 0; i < source.length; i++)
		//    System.out.println(source[i]);
	}
}