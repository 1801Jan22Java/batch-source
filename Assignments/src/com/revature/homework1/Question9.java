package com.revature.homework1;

public class Question9 {
	
	public static void prime(int [] values) {
		
		boolean flag = true;
		for (int i = 0; i < 100; i++) {
			flag = true;
			for(int j = 2; j < i; j++) {
				if (values[i]%j == 0) {
					flag = false;
				}
			}
			if (flag) {
				System.out.print(values[i] + " ");
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		int [] values = new int [100];
		for (int i = 0; i < 100; i++) {
			values[i] = i + 1;
		}
		
		prime(values);
		
	}

}
