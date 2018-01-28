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
		evenSum = 0;
		oddSum = 0;
	}
	
	public void doThing() {
		numbers = new ArrayList<Integer>();
		for(int i = 1; i < 11; i++) {
			numbers.add(i);
		}
		for(Integer n: numbers) {
			if(n % 2 == 0) 
				evenSum += n;
			else
				oddSum += n;
		}
		
		System.out.println("Sum of even numers: " + evenSum);
		System.out.println("Sum of odd numbers: " + oddSum);
		
		for(int n = 0; n < numbers.size(); n++) {
			if(isPrime(n))
				numbers.remove(n);
		}
		
		System.out.println("Composite numers: ");
		for(int o = 0; o < numbers.size(); o++) {
			System.out.print(o + '\t');
		}
		System.out.println();
	}
	
	private boolean isPrime(Integer num) {
		if((num == 1) || (num == 2)){
			return true;
		}
		for(int i = 2; i < num; i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
}
