package com.revature.homework1;

public class Question12 {
	
	public static void evens() {
		
		int [] arr = new int [100];
		for(int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		
		for(int num:arr) {
			if (num%2 == 0) {
				System.out.print(num + " ");
			}
		}	
	}
	
	public static void main(String[] args) {
		evens();
	}

}
