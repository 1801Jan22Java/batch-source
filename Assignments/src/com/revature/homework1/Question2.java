package com.revature.homework1;

public class Question2 {
	
	
	public static int computeFibonaci(int num){
		
		int fibonaciNumber = 0;
		if(num == 0) {
			return 0;}
		if(num <= 2) {
			
			return 1;	
		}
		else {
			fibonaciNumber = computeFibonaci(num - 1) + computeFibonaci(num - 2);
			return fibonaciNumber;
		}
		
		

		
		
		
		
		
		
	}

	public static void main(String[] args) {
		
		
		for(int i = 0; i<25; i++) {
			
			System.out.println(computeFibonaci(i));
		}
		
		
		
		
		}
		
		
		


	}


