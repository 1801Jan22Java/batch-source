package com.revature.GeneMutations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class GeneMutations {
	private ArrayList<String> bank;

	public GeneMutations() {
		super();
	}

	public GeneMutations(String filename) {
		this.bank = getBank(filename);
	}

	// placeholder for file IO
	private ArrayList<String> getBank(String filename) {
		ArrayList<String> bank = new ArrayList<String>();

		// For getting one line at a time
		String line = null;

		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bank;
	}

	public boolean checkValidMutation(ArrayList<String> bank, String gene) {
		for (String bankGene : bank) {
			if (gene.equals(bankGene)) {
				return true;
			}
		}
		return false;
	}

	public int countMutations(String gene, String bankGene) {
		String[] splitGene = gene.split("");
		String[] splitBankGene = bankGene.split("");
		int counter = 0;

		for (int i = 0; i < splitGene.length; i++) {
			if (splitGene[i].equals(splitBankGene[i])) {
				counter++;
			}
		}
		return counter;
	}

	public void assessor(String startGene, String endGene, ArrayList<String> bank) {
		// Check if in gene pool, if not, short circuit return -1

		if (!checkValidMutation(bank, endGene)) {
			System.out.println("Start: " + startGene);
			System.out.println("End: " + endGene);
			System.out.println("Bank: " + bank.toString());
			System.out.println("-1");
		}

		// Case if start and end gene is already in gene pool
		else if (checkValidMutation(bank, startGene) & checkValidMutation(bank, endGene)) {
			System.out.println("Start: " + startGene);
			System.out.println("End: " + endGene);
			System.out.println("Bank: " + bank.toString());
			System.out.println("0");
		} else {
			String[] splitStart = startGene.split("");
			String[] splitEnd = endGene.split("");
			String[] geneHolder = new String[8];
			int counter = 0;

			// Check if valid for each iteration of gene mutations
			boolean keepGoing = true;

			while (keepGoing) {
/*
 * Messed up here, going through for loop with bankGene instead of the length of the string of the input
 * start gene.
 */
				for (String bankGene : bank) { 
					for (int i = 0; i < splitStart.length; i++) {
						// If character at a location is not equal, switch start, check with gene bank
						if (!splitStart[i].equals(splitEnd[i])) {
							splitStart[i] = splitEnd[i];
							String checkStr = String.join("", splitStart);

							// if mutation is not in gene bank, return default message.
							if (!checkValidMutation(bank, checkStr)) {
								System.out.println("Start: " + startGene);
								System.out.println("End: " + endGene);
								System.out.println("Bank: " + bank.toString());
								System.out.println("-1");

								// Exit loop once results are shown
								keepGoing = false;
							}
							// add to counter
							counter++;
						}
					}
				}
				// Exit loop if done.
				keepGoing = false;
			}

			String checkStr = String.join("", splitStart);
			if (!checkValidMutation(bank, checkStr)) {
				System.out.println("Start: " + startGene);
				System.out.println("End: " + endGene);
				System.out.println("Bank: " + bank.toString());
				System.out.println("-1");
			} else {
				System.out.println("Start: " + startGene);
				System.out.println("End: " + endGene);
				System.out.println("Bank: " + bank.toString());
				System.out.println(counter);
			}
		}
		System.out.println("");

	}

}
