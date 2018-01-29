package com.revature.GeneMutations;

import java.util.ArrayList;

public class GeneMutations {
	private ArrayList<String> bank;

	public GeneMutations() {
		super();
	}

	public GeneMutations(String filename) {

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
		else if(checkValidMutation(bank, startGene) & checkValidMutation(bank, endGene)){
			System.out.println("Start: " + startGene);
			System.out.println("End: " + endGene);
			System.out.println("Bank: " + bank.toString());
			System.out.println("0");
		}
		else {
			String[] splitStart = startGene.split("");
			String[] splitEnd = endGene.split("");
			String[] geneHolder = new String[8];
			int counter = 0;

			// Check if valid for each iteration of gene mutations
			boolean keepGoing = true;

			while (keepGoing) {

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
								keepGoing=false;
							}
							// add to counter
							counter++;
						}
					}
				}
				// Exit loop if done.
				keepGoing = false;
			}
			
			System.out.println("Start: " + startGene);
			System.out.println("End: " + endGene);
			System.out.println("Bank: " + bank.toString());
			System.out.println(counter);
		}
		System.out.println("");

	}

}
