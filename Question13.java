package com.revature.homework1;

class Question13{
	
	public static void main(String[] args) {
		int last = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i+1; j++) {
			if (last == 0)
				System.out.print("0");
			else
				System.out.print("1");
			if (last == 1)
				last = 0;
			else
			    last = 1;		
			}
		System.out.println();
		}
   }
}