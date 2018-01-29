package com.revature;

import java.io.*;

class MutationLogic{
	
	String currentStart;
	String currentTarget;
	String[] currentBank;
	
	//mutations are given point values
	// a mutation to A,C,G, or T in the target string
	// are given values of 1,2,3 or 4 respectively
	// 0 represents no mutation at index
	int[] findPointMutations(String start, String target) {
		int[] pointMutations = new int[8];
		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) == target.charAt(i))
				pointMutations[i] = 0;
			else {
				switch (target.charAt(i)) {
				case 'A':
					pointMutations[i] = 1;
				case 'C':
					pointMutations[i] = 2;
				case 'G':
					pointMutations[i] = 3;
				case 'T':
					pointMutations[i] = 4;
				}
			}
		}
		return pointMutations;
	}
	
	void readData(File input) throws FileNotFoundException{
		BufferedReader br = new BufferedReader(new FileReader(input));
		String firstLine = br.readLine();
		String[] firstArray = firstLine.split("\"");
		currentStart = firstArray[1];
		String secondLine = br.readLine();
		String[] secondArray = secondLine.split("\"");
		currentTarget = secondArray[1];
	}
	
	
}
	