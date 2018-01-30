package com.revature.codechallenge1;

import java.util.ArrayList;
import java.util.List;

public class MutateQuery {
	
	private static final char[] GENES= {'A', 'C', 'G', 'T'};
	
	public static int query(String start, String end, List<String> bank) {
		if (start.equals(end)) return 0;
		
		int result = queryHelper(start, end, bank, new ArrayList<String>());
		
		if (result == Integer.MAX_VALUE) return -1;
		
		return result;
	}
	
	private static String swap(String s, int idx, char c) {
		char[] temp = s.toCharArray();
		temp[idx] = c;
		
		
		return new String(temp);
	}
	
	private static int queryHelper(String current, String end, List<String> bank, List<String> used) {
		int minResult = Integer.MAX_VALUE;
		if (used.size() == bank.size()) {
			return Integer.MAX_VALUE;
		}
		for (int i = 0; i < current.length(); i++) {
			for (char c : GENES) {
				String temp = swap(current, i, c);
				if (temp.equals(end)) {
					return 1 + used.size();
				}
				if (bank.contains(temp) && !used.contains(temp)) {
					List<String> addUsed = new ArrayList<String>(used);
					addUsed.add(temp);
					int currResult = queryHelper(temp, end, bank, addUsed);
					if (currResult < minResult) {
						minResult = currResult;
					}
				}
			}
		}
		return minResult;
	}
	
}
