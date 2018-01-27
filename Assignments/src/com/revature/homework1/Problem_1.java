package com.revature.homework1;

public class Problem_1 {
	
	public static void bubbleSort(int[] things) {
		int temp =  0,no_swap = 1;
		
		int[] stuff = things;
		
		while(no_swap != 0) {
			no_swap = 0;
			for(int i = 0; i<stuff.length-1; i++) {
				if( i <= (stuff.length -1)) {
					if(stuff[i]> stuff[i+1]) {
						temp = stuff[i+1];
						stuff[i+1] = stuff[i];
						stuff[i] = temp;
						no_swap += 1;
					}
				}
			}
		}
		
		for(int i : stuff) {
			System.out.println(i);
		}
			
	}
	
	public static void main(String args[]) {
		int[] thing = {1,0,5,6,3,2,3,7,9,8,4};
		bubbleSort(thing);
	}

}
