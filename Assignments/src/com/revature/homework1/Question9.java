package com.revature.homework1;
import java.util.ArrayList;
/*
 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime
numbers to the console.

 */
public class Question9 {
	private ArrayList<Integer> numbers;
	private ArrayList<Integer> primes;
	
	public Question9() {
		numbers = new ArrayList<Integer>();
		primes = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) {
			numbers.add(i);
		}
	}
	
	public void getPrimes(){
		boolean prime = true;
		for(Integer i: numbers) {
			prime = true;
			for(int j = 2; j < i; j++) {
				if(i % j == 0)
					prime = false;
			}
			if(prime)
				primes.add(i);
		}
	}
	
	public void printPrimes() {
		System.out.println("Prime numbers from 1 to 100");
		int counter = 1;
		for(Integer i: primes) {
			if(counter % 8 == 0) // cosmetic, to make the output easier to read
				System.out.println();
			System.out.print(i + ",  ");
			counter++;
		}
		System.out.println();
	}
}
