package com.revature.homework1;

import java.util.ArrayList;
import java.util.Iterator;

public class Question19 {
	public static void main(String[] args) {
		//After looking at some documentation, I discovered that the serialize warning really doesn't
		//matter in this case, so I went ahead and suppressed it.
		@SuppressWarnings("serial")
		ArrayList<Integer> arrList = new ArrayList<Integer>() {{
			//Probably smarter to use a for loop and add i, but I wanted to reinforce this way of 
			//instantiating an ArrayList with values.
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
			add(6);
			add(7);
			add(8);
			add(9);
			add(10);
		}};
		
		int evenCount = 0;
		for(int i = 1; i <= 9; i += 2) {
			evenCount += arrList.get(i);
		}
		
		int oddCount = 0;
		for(int i = 0; i <= 8; i += 2) {
			oddCount += arrList.get(i);
		}
		
		Iterator<?> it = arrList.iterator();
		
		while(it.hasNext()) {
			if(isPrime((int)it.next())) {
				it.remove();
			}
		}
		
		System.out.println(evenCount);
		System.out.println(oddCount);
		for(int n: arrList) {
			System.out.println(n);
		}
	}
	
	public static boolean isPrime(int n) {
		if(n == 2) {
			return true;
		}
		
		if(n%2 == 0) {
			return false;
		}else{
			for(int i = 3; i*i <= n; i+=2) {
				if(n%i == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
}
