package com.revature.homework1;

import java.util.ArrayList;

public class ProblemNineteen {
	
	public static void funWithArrayList() {
		ArrayList<Integer> stuff = new ArrayList<>();
		ArrayList<Integer> bank = new ArrayList<>();
		int adding_evens = 0,adding_odds =0;
		boolean is_prime = true;
		for(int i = 1; i<11; i++) {
			stuff.add(i);
		}
		int count = 0;
		for(int element : stuff) {
			if(element%2 ==0) {
				adding_evens+= element;
			}else {
				adding_odds+= element;
			}
			
			if(element<=2) {
				bank.add(element);
				stuff.remove(count);
			}
			else {
				
				for(int i = 0;i<bank.size();i++) {
					if(element%bank.get(i)==0) {
						is_prime= false;
						break;
					}
					else {
						is_prime = true;
						
					}
				}
				if(is_prime = true) {
					stuff.remove(count);
					bank.add(element);					
				}
			}
			count+=1;
		}
		System.out.println(adding_evens);
		System.out.println(adding_odds);
		
		
	}

	public static void main(String[] args) {
		funWithArrayList();
		
	}
}
