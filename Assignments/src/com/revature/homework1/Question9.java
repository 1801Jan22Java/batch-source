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
		
		for (int i = 1; i <= 100; i++) {
			list.add(new Integer(i));
		}
		
		
		
		for (Integer i : list) {
			if (i == 1) {
				prime.add(i);
			}else if (i == 2) {
				prime.add(i);
			}else {
				add = true;
				for(Integer j : prime) {
					if (j % i == 0) {
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
