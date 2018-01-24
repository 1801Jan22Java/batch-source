package com.revature.homework1;

import java.util.ArrayList;

/*
 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the
 * prime numbers to the console.
 */
public class Question9 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList();
		ArrayList<Integer> prime = new ArrayList<>();
		boolean add = false;
		
		//Load the first array list with numbers 1 through 100
		for (int i = 1; i <= 100; i++) {
			list.add(new Integer(i));
		}
		
		
		for (Integer i : list) {
			//need to add 1 to start the list
			if (i == 1) {
				prime.add(i);
			}else if (i == 2) {//need add two because 1 is a factor of everything
				prime.add(i);
			}else {
				//we assume it is prime before we start checking
				add = true;
				//we iterate through the current prime numbers to see if they are factors of the current number
				for(int j = 1; j < prime.size(); j++) {
					//if the current number is evenly divisible by he current prime number then it is not added
					if (i % prime.get(j) == 0) {
						add = false;
						break;
					}
				}
				if (add) {
					prime.add(i);
				}
			}
		}
		System.out.println(prime.toString());

	}

}
