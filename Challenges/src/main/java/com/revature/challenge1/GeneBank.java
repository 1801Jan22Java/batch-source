package com.revature.challenge1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GeneBank {
	public static int countModifications(String start, String end){
		if (start.equals(end)) {
			return 0;
		}
		int count = 0;
		ArrayList<String> bank = new ArrayList<>();
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\challenge1\\bank.txt"));
			int i = 0;
			while(input.hasNextLine()) {
				bank.add(input.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Sorry, that file was not found.");
		}
		ArrayList<Boolean> successes = new ArrayList<>();
		// Step through each character of the starting gene
		for (int i = 0; i < start.length(); i++) {
			// If the character in start doesn't character in end, find mutation
			if (start.charAt(i) != end.charAt(i)) {
				successes.add(i, (Boolean)false);
				// Step through each string in bank to compare character
				for (String x : bank) {
					// If character found, add success to list and increment count
					if (x.charAt(i) == end.charAt(i)) {
						successes.set(i, (Boolean)true);
						count++;
					}
				}
			}
		}
		boolean overallSuccess = true;
		for (Boolean x : successes) {
			if (x == false) {
				overallSuccess = false;
			}
		}
		if (overallSuccess == false) {
			return -1;
		} else {
			return count;
		}
	}
}

