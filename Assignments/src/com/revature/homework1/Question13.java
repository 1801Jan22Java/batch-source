package com.revature.homework1;

public class Question13 {
	public static void main(String[] args) {
		int tiers = 4;
		for(int i = 1; i <= tiers; i++) {
			for(int j = 0; j < i; j++) {
				if(isEven(j)) {
					System.out.print("0 ");
				}else {
					System.out.print("1 ");
				}
			}
			
			System.out.println();
		}
	}
	
	public static boolean isEven(int n) {
		return n%2==0;
	}
}
