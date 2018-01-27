package com.revature.homework1;

public class Problem_4 {
	
	public static void fac_torial(int number) {
		int base=2,answer=1;		
		
		for(int i = 0; i < number-1; i++) {
			answer *= base;
			base+= 1;
					
		}
		
		System.out.print(answer);
	}
	
	public static void main(String args[]) {
		fac_torial(8);
	}

}
