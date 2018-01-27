package com.revature.homework1;

public class Problem13 {
	
	public static void illuminati() {
		boolean done = false,got_somefin=false,got_nuffin=true;
		int counter = 1;
		while(!done) {
			for(int i = 0; i<counter;i++) {
				if(got_somefin == false) {
					System.out.print("0");
					got_somefin = true;
				}
				else {
					System.out.print("1");
					got_somefin = false;
				}
			}
			System.out.println("\n");
			counter +=1;
			if(counter == 5) {
				done = true;
			}
			
		}
	}
	public static void main(String args[]) {
		illuminati();
		//System.out.println("0");
	}

}
