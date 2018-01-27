package com.revature.homework1;

import java.util.*;

// almost done
public class Problem_8 {

	public static void funWithLists(String[] things) {
		ArrayList<String> morethings = new ArrayList<String>();
		ArrayList<String> drone = new ArrayList<String>();

		String maybe_drone;
		boolean is_drone = true;

		for (int i = 0; i < things.length; i++) {
			is_drone = true;
			maybe_drone = things[i];
			for (int j = 0; j < maybe_drone.length() / 2; j++) {
				if (things[i].charAt(j) != things[i].charAt(things[i].length() - j-1)) {
					// not a pallendrone
					is_drone = false;
				}
			}
			if (is_drone) {
				drone.add(things[i]);
			}
			morethings.add(things[i]);
		}

		for (String m : drone) {
			System.out.println(m);
		}


	}

	public static void main(String args[]) {
		String[] things = { "karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy",
				"did" };
		
		funWithLists(things);

	}

}
