package com.revature.homework1;

import java.util.*;

/*
 * Create an ArrayList and insert integers 1 through 10. 
 * Display the ArrayList. Add all the even numbers up and display the result. 
 * Add all the odd numbers up and display the result. 
 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 */

public class Question19 {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++) {
			numbers.add(new Integer(i));
		}
		
		funWithArrayLists(numbers);
		
		System.out.println();
		
		numbers = new ArrayList<>();
		
		for (int i = 1; i <= 20; i++) {
			numbers.add(new Integer(i));
		}
		
		funWithArrayLists(numbers);
	}
	
	public static void funWithArrayLists(ArrayList<Integer> list) {
		System.out.println(list.toString());
		int evenTotal = 0;
		int oddTotal = 0;
		ArrayList<Integer> primes = new ArrayList<>();
		Iterator<Integer> it1;
		Integer current;
		boolean remove = false;
		
		
		//Adds up all the evens in the list
		for (Integer i : list) {
			if (i % 2 == 0) {
				evenTotal += i;
			}
		}
		
		System.out.println("The sum of the even numbers = " + evenTotal);
		
		//Adds all the odds together
		for (Integer i : list) {
			if (i % 2 != 0) {
				oddTotal += i;
			}
		}
		
		System.out.println("The sum of the even numbers = " + oddTotal);
		
		
		//Need to remove 1 and 2 from the list in order to get the rest of the prime numbers
		if (list.contains(new Integer(1))) {
			list.remove(new Integer(1));
		}
		if (list.contains(new Integer(2))) {
			list.remove(new Integer(2));
		}
		
		//add 1 and 2 to the prime numbers list and sort it to ensure order
		Collections.addAll(primes, new Integer(1), new Integer(2));
		Collections.sort(primes);
		
		it1 = list.iterator();
		
		while (it1.hasNext()) {
			current = it1.next();
			remove = true;
			
			//Check the current integer against all the prime numbers found already to see if it is prime
			for (int i = 1; i < primes.size(); i++) {
				if (current % primes.get(i) == 0) {
					remove = false;
					break;
				}
			}
			//if it is prime remove it and add it to the prime list
			if(remove) {
				it1.remove();
				primes.add(current);
			}
		}

		System.out.println(list.toString());
		
		
	}

}
