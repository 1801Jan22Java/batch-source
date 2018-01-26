package com.revature.homework1;

public class Question13 {

	public static void main(String[] args) {

		boolean zero = true;
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (zero) {
					System.out.print("0 ");
					zero = false;
				} else {
					System.out.print("1 ");
					zero = true;
				}
			}
			System.out.println();

		}
	}
}
