package com.revature.homework1;

import java.util.ArrayList;

public class Question12 {
	public static void main(String[] args) {
		ArrayList<Integer> nums	= new ArrayList<Integer>();
		
		for(int i = 1; i <= 100; i++) {
			nums.add(i);
		}
		
		for(int i:nums) {
			if(isEven(i))
				System.out.println(i);
		}
	}
	
	public static boolean isEven(int n) {
		return n%2==0;
	}
}
