package com.revature.homework1;

import java.util.ArrayList;
import java.util.List;

public class Question19 {

	public static void main(String[] args) {
		// ​. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the
		//even numbers up and display the result. Add all the odd numbers up and display the result.
		//Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		//full arrayList with nubmers 1 to 10
		System.out.print("Numbers: ");
		for(int i = 1; i < 11; i++) {
			numbers.add(i);
			System.out.print(i + " ");
		}
		
		//Add up all even numbers and odd numbers (seperatly)
		int evenSum = 0;
		int oddSum = 0;
		for(int i : numbers) {
			if(i % 2 == 0)
				evenSum += i;
			else
				oddSum += i;
			
		}
		
		System.out.println("\nSum of even numbers: " + evenSum);
		System.out.println("Sum of odd numbers: " + oddSum);
		
		//Loop through arrayList and remove prime numbers
		for(int i = numbers.size() - 1; i >= 0; i--) {
			
			if(Question9.isPrime(numbers.get(i))) {
				numbers.remove(i);
			}
		}
		
		//Print out the new numbers list
		System.out.println("List with primes removed: ");
		for(int i : numbers)
			System.out.print(i + " ");
		
	}

}
