package com.revature.homework1;

class Question12{
	
	public static void main(String[] args) {
		int[] nums = new int[100];
		for (int x = 1; x <= 100; x++)
			nums[x-1] = x;
		for (int y : nums) {
			if (y % 2 == 0)
				System.out.print(y+" ");
		}
	}
}