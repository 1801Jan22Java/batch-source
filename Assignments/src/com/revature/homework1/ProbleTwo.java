package com.revature.homework1;

public class ProbleTwo {
	
	public static void fibronocci() {
		int[] stuff = new int[25];
		int alpha = 0, beta = 1, count=2;
		
		stuff[0] = alpha;
		stuff[1] = beta;
		
		while(count< 25) {
			stuff[count] = stuff[count -2]+ stuff[count-1];
			count+=1;
		}
		for(int elements : stuff) {
		System.out.print(elements + " ,");
		}
	}
	
	public static void main(String args[]) {
		fibronocci();
	}

}
