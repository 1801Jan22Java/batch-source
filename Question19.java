package com.revature.homework1;

import java.util.*;

class Question19{
    
	public static void main(String[] args) {
	int evenSum = 0;
	int oddSum = 0;
	ArrayList<Integer> list = new ArrayList<Integer>();
	for (int i = 1; i < 11; i++)
		list.add(i);
	for (int x : list)
		System.out.print(x+" ");
	System.out.println();
	
	for (int j = 1; j < 11; j++) {
		if (j % 2 == 0)
			evenSum += j;
	}
	System.out.println(evenSum);
	
	for (int k = 1; k < 11; k++) {
		if (k % 2 == 1)
			oddSum += k;
	}
	System.out.println(oddSum);
	
	for (int m = 1; m <= 10; m++) {
		if (checkPrimality(m)) {
			Integer prime = new Integer(m);
	        list.remove(prime);		
		  }
	    }
	
	for (int x : list)
		System.out.print(x+" ");
	}
	
	static boolean checkPrimality(int source) {
		double limit = Math.sqrt(source);
	    for (int i = 2; i < limit+1; i++) {
	    	if (source % i == 0)
	    		return false;
	    }
	    if (source == 1)
	    	return false;
	    return true;
	}
}