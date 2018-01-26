package com.revature.homework1;

public class Question12 {

	public static void main(String[] args) {
		
		int[] inty = new int[100];
		
		//fill the array
		for(int i=0; i<100; i++) {
			inty[i] = i+1;
		}
		
		System.out.println("all the evens from 1 to 100:");
		//find our boys
		for(int i : inty) {
			if(i%2==0) {
				System.out.println(i+" ");
			}
		}
	}
}
