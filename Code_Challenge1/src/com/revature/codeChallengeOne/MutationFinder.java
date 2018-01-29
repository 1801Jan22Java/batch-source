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
			temp = reader.readLine();
			strArr = temp.split(",");
			bank = new GeneBank(strArr.length);
			for(int i = 0; i < strArr.length; i++) {
				bank.add(new Gene(strArr[i]));
			}
			
			for(int i = 0; i < bank.getSize(); i++) {
				// logic to determine validity
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
