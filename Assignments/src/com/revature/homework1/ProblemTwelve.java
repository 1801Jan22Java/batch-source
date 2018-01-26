package com.revature.homework1;

public class ProblemTwelve {
	
	public static void evenSteven() {
		int[] hundo = new int[100];
		for(int i = 1; i<101; i++) {
			hundo[i-1] = i;
		}
		
		for(int element:hundo) {
			if(element%2 == 0) {
				System.out.print(element+", ");
			}
		}
	}
	
	
	public static void main(String args[]) {
		evenSteven();
	}

}
