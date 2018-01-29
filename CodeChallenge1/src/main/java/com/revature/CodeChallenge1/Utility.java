package com.revature.CodeChallenge1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utility {

	public Utility() {}
	
	List<String> genes;
	
	public void inputGenes() {
		
		//Load genes in from file Data.txt Data2.txt Data3.txt
		genes = readGeneFile("src/res/Data.txt");
		
		//Set the start and end genes, remve them from the gene bank
		String startGene = genes.get(0);
		String endGene = genes.get(1);
		genes.remove(1);
		genes.remove(2);
		
		System.out.println("Start Gene: " + startGene);
		System.out.println("End Gene: " + endGene);
		System.out.println("\nBank Genes:");
		for(String s : genes) {
			System.out.println(s);
		}
		System.out.println();
		
		//Use a set to prevent duplicates in the gene pool
		Set<String> currentGen = new HashSet<String>();
		currentGen.add(startGene);
		
		//Count number of mutations we need
				int mutationCount = 0;
				
		//Absolute maximum number of mutations possible
		while(mutationCount < genes.size()) {
			Set<String> nextGen = new HashSet<String>();
			
			for(String s : currentGen) {
				nextGen.addAll(getValidMutations(s));
			}
			
			currentGen = nextGen;
			
			mutationCount++;
			
			System.out.println("Generation " + mutationCount + " simulated...");
			
			System.out.println(currentGen);
			
			if(currentGen.contains(endGene)) {
				System.out.println("*MATCH* Found a match after " + mutationCount + " mutations!");
				return;
			}
			
		}
		
		
		System.out.println("No valid mutation path!");
		
	}
	
	//Returns a list of all the genes within 1 mutation of the input gene - a valid mutation
	public Set<String> getValidMutations(String gene) {
		
		//List to store valid mutations
		Set<String> validMutations = new HashSet<String>();
		
		//Convert gene to char array for comparisions
		char[] mutatorC = gene.toCharArray();
		
		//Loop through potential mutations
		for(String g : genes) {
			
			//Convert to char array
			char[] mutationC = g.toCharArray();
			
			//If genes are of different lengths they are incompatible
			if(mutationC.length != mutatorC.length)
				break;
			
			//Now check to see if genes are one mutation away from eachother
			int diffs = 0;
			for(int i = 0; i < mutatorC.length; i++) {
				if(mutatorC[i] != mutationC[i])
					diffs++;
			}
			//If diffs is 1 we have a valid mutation
			if(diffs == 1)
				validMutations.add(g);
		}
		
		return validMutations;
	}
	
	//Reads genes in from a file
	public static List<String> readGeneFile(String fileName) {
		try {
			//Make a file reader so we can read text in from the file
			FileReader reader = new FileReader(fileName);
			BufferedReader textRead = new BufferedReader(reader);
			
			List<String> data = new ArrayList<String>();
			
			//Keep reading lines until eof add in a \n character after each line
			while(textRead.ready())
				data.add((textRead.readLine()));
			
			return data;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return null;
	}
}
