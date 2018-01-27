package com.revature.homework1;

import java.util.ArrayList;

public class Problem_9 {
	
	public static void primesAreFun() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Integer> bank = new ArrayList<Integer>();
		boolean has_a_factor = false;
		
		for(int i = 1; i<101;i++) {
			if(i<=2) {
				numbers.add(i);
				bank.add(i);
			}
			else {
				has_a_factor = false;
				//System.out.println(bank.size);
				for(int j = 1;j<bank.size();j++) {
					if(i%bank.get(j)==0) {
						has_a_factor = true;
					}
				}
				
				if (has_a_factor == false) {
					numbers.add(i);
					bank.add(i);
				}
			}
			
		}
		System.out.print("Numbers : ");
		for(int p : numbers) {
			System.out.print(p+", ");

		}
	}

	
	public static void main(String args[]) {
		
		primesAreFun();
		
		
		
		
	}
}
