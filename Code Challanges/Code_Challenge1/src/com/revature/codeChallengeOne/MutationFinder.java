package com.revature.codeChallengeOne;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class MutationFinder {

	public static final String FILENAME = "src\\com\\revature\\codeChallengeOne\\Data.txt";
	// a CSV holding the Start, End, and Bank in that order
	public enum letters {
		A, G, C, T
	}
	
	public static void main(String[] args) {
		try{
			boolean valid;
			String[] strArr;
			String temp = new String();
			GeneBank bank;
			BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
			Gene start = new Gene((reader.readLine()));
			Gene end = new Gene((reader.readLine()));
			Gene current;
			temp = reader.readLine();
			strArr = temp.split(",");
			bank = new GeneBank(strArr.length);
			for(int i = 0; i < strArr.length; i++) {
				bank.add(new Gene(strArr[i]));
			}
			
			for(int i = 0; i < bank.getSize(); i++) {
				/*
				 * Logic to determine validity: 
				 * beginning with gene start (declared above)
				 * 		determine if there exists a valid mutation in the bank, or if end is a valid mutation
				 * 			if true, set current to that reference and go into loop
				 * 			else, return -1 as value (preferably throw exception, but meh)
				 * Loop:
				 * 		determine if there exists a valid mutation within 
				 * 		the gene bank, or if end (declared above) is a valid mutation
				 * 			if true, continue loop, setting current to that reference
				 * 			else, return -1 as value (preferably throw exception, but meh)
				 * 		if end is a valid mutation from 'current', exit loop and return value 
				 * 		 
				 */
				
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Some sorta IOException");
			e.printStackTrace();
		}
	}
}
