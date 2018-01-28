package com.revature.homework1;

public class Question13 {
	public static void binaryTriforce(int rows) {
		int layers = rows;
		int print = 0;
		for (int i = 1; i <= layers; i++) {
			for (int j = 1; j <= i; j++) {
				if (print == 0) {
					System.out.print("0 ");
					print = 1;
				} else {
					System.out.print("1 ");
					print = 0;
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
