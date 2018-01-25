//Done!

package com.revature.homework1;
import java.util.*;

public class Question9 {
	
	//Method to determine whether or not a number is prime
	public static boolean isPrime(int num) {
		boolean isPrime = true;
		for(int i = 2; i <= num/2; i++) {
			//If num divides into i with no remainder, num is NOT prime
			if(num % i == 0) {
				isPrime = false;
			}
		}
		return isPrime;
	}
	
	public static void main(String[] args) {
		//Create an ArrayList to hold numbers between 1 and the max
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int max = 100;		//The max value
		
		System.out.println("Prime numbers from 1 through " + max + ": ");
		
		//Print the number only if isPrime returns true on it
		for(int i = 1; i <= max; i++) {
			numbers.add(i);
			if(isPrime(i)) {
				System.out.print(i + " ");
			}
		}
	}
}
