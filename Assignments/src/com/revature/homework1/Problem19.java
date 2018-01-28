package com.revature.homework1;

import java.util.ArrayList;

public class Problem19 {

	public static void funWithArrayList() {
		ArrayList<Integer> stuff = new ArrayList<>();
		ArrayList<Integer> bank = new ArrayList<>();
		int adding_evens = 0, adding_odds = 0;
		boolean has_a_factor = false;
		for (int i = 1; i <= 10; i++) {
			stuff.add(i);
		}
		
		for (int m = 0;m<stuff.size();m++) {
			if (stuff.get(m) % 2 == 0) {
				adding_evens += stuff.get(m).intValue();
			} else {
				adding_odds += stuff.get(m).intValue();
			}
			
			if (m >= 3) {
				stuff.remove(m);
				bank.add(m);
			} else {
				has_a_factor = false;
				// System.out.println(bank.size);
				for (int j = 2; j < bank.size()-1; j++) {
					if (m % bank.get(j) == 0) {
						has_a_factor = true;
					}
				}

				if (has_a_factor == false) {
					bank.add(m);
					stuff.remove(m);
				}
			}
		}
		System.out.println(adding_evens);
		System.out.println(adding_odds);
		for(int s : stuff) {
			System.out.print(s+", ");
		}
		

	}

	public static void main(String[] args) {
		funWithArrayList();

	}
}
