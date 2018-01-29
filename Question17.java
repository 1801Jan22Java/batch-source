package com.revature.homework1;

import java.util.Scanner;

class Question17{
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int principal = in.nextInt();
		int rate = in.nextInt();
		int time = in.nextInt();
		int accrued = principal*(1+rate*time);
		//System.out.println(accrued);
	}
}