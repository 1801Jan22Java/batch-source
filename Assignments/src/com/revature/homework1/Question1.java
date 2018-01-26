package com.revature.homework1;

import java.util.Arrays;

public class Question1 {

	public static void main(String[] args) {

		int[] a = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

		bubbleSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void bubbleSort(int[] intArray) {

		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0; j < intArray.length - i - 1; j++) {
				if (intArray[j] > intArray[j + 1]) {
					int temp = intArray[j + 1];
					intArray[j + 1] = intArray[j];
					intArray[j] = temp;
				}
			}
		}
	}
}
