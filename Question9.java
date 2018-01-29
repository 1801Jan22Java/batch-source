package com.revature.homework1;

import java.util.*;

class Question9{
	public static void main(String[] args) {
	ArrayList<Integer> nums = new ArrayList<Integer>();
	for (int i = 1; i < 100; i++) {
		nums.add(i);
	    if (checkPrimality(i))
	    	System.out.println(i);
	}
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
	