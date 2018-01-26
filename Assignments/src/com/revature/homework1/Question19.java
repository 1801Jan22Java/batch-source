package com.revature.homework1;
import java.util.ArrayList;
/*
 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the
even numbers up and display the result. Add all the odd numbers up and display the result.
Remove the prime numbers from the ArrayList and print out the remaining ArrayList.

 */
public class Question19 {
	private ArrayList<Integer> numbers;
	private Integer evenSum;
	private Integer oddSum;

	
	public Question19() {
		for(int i = 1; i < 11; i++) {
			numbers.add(i);
		}
		evenSum = 0;
		oddSum = 0;
	}
	
	public void doThing() {
		for(Integer n: numbers) {
			if(n % 2 == 0) 
				evenSum += n;
			else
				oddSum += n;
		}
		
		System.out.println("Sum of even numers: " + evenSum);
		System.out.println("Sum of odd numbers: " + oddSum);
		
		for(Integer m: numbers) {
			for(int i = 2; i < 11; i++) {
				if((m % i == 0) && (m != i))
					numbers.remove(m);
			}
		}
		
		System.out.println("Composite numers: ");
		for(Integer o: numbers) {
			System.out.print(o);
		}
	}
}
