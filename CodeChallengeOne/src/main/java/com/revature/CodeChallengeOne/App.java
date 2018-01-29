package com.revature.CodeChallengeOne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This certainly doesn't actually work. I think I have a pretty good start, and given another thirty minutes
 * I might finish.
 */
public class App 
{
    public static void main( String[] args )
    {
        //
    }
    
}

class Genes{
	private String startSequence;
	private String endSequence;
	private ArrayList<String> sequenceBank;
	
	public Genes() {
		super();
	}
	
	public Genes(String startSequence, String endSequence, ArrayList<String> sequenceBank) {
		this.startSequence = startSequence;
		this.endSequence = endSequence;
		this.sequenceBank = sequenceBank;
	};
	
	public static Genes createGenes(String path) {
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			//Given more time, I would have create a regex that captured characters of AGTC
			//Iterating through lines and capture groups.
			String[] start = line.split("\"");
			String[] end = line.split("\"");
			String[] bank = line.split("\"");
			
			String startSeq = start[1];
			String endSeq = end[1];
			ArrayList<String> bankSeqs = new ArrayList<String>();
			
			for(int i = 0; i < bank.length - 1; i++) {
				bankSeqs.add(bank[i]);
			}
			
			return new Genes(startSeq, endSeq, bankSeqs);
			
		}catch(IOException e) {
			System.out.println("File cannot be found.");
		};
		
		return new Genes();
	}
	
	public int validMutation() {
		String currentSequence = startSequence;
		if(isOneStep(currentSequence, endSequence)) {
			return 1;
		}else {
			for(String sequence: sequenceBank) {
				if(isOneStep(currentSequence, sequence)) {
					//So here, I would have to create a copy off this ArrayList
					//and then remove the relevant sequence.
					sequenceBank.remove(sequence);
					return 1 + validMutation(currentSequence, sequenceBank);
				}
			}
		}
		
		return -1;
	}
	
	public int validMutation(String currentSequence, ArrayList<String> sequences) {

		if(isOneStep(currentSequence, endSequence)) {
			return 1;
		}else {
			for(String sequence: sequences) {
				if(isOneStep(currentSequence, sequence)) {
					sequenceBank.remove(sequence);
					return 1 + validMutation(currentSequence, sequenceBank);
				}
			}
		}
		
		return -1;
	}
	
	private boolean isOneStep(String firstSequence, String secondSequence) {
		
		int diff = 0;
		
		for(int i = 0; i < firstSequence.length(); i++) {
			if(firstSequence.charAt(i) != secondSequence.charAt(i)) {
				diff++;
			}
			
			if(diff > 1) {
				return false;
			}
		}
		
		return true;
	}
}