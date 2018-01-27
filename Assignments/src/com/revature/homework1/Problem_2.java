package com.revature.homework1;

public class Problem_2 {
	
	public static void fibronocci() {
		int[] stuff = new int[25];
		int alpha = 0, beta = 1, count=2;
		
		stuff[0] = alpha;
		stuff[1] = beta;
		
		while(count< 25) {
			stuff[count] = stuff[count -2]+ stuff[count-1];
			count+=1;
		}
		int count2 = 0;
		for(int elements : stuff) {
			if(count2 == 24) {
				System.out.print(elements);
			}
			else {
				System.out.print(elements + " ,");
			}
			count2+=1;
		}
	}
	
	public static void main(String args[]) {
		fibronocci();
	}

}
