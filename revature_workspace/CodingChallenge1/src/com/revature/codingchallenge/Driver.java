package com.revature.codingchallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Driver {
	public static void main(String[] args)
	{
		Bank b = new Bank();
		b.addSequence("AACCGGTT");
		b.addSequence("AAACGGTA");
		b.addSequence("AAGGCCTT");
		
		//	String[] bankArray =b.convertToArray();
		/*	for(int i =0;i<bankArray.length;i++)
		{
			System.out.println(bankArray[i]);
		}
		 */	
		File file = new File("Data.txt");
		System.out.println(b.bankList.toString());
		System.out.println(b.numMutations("AACCGGTG", "AAACGGTA"));
		System.out.println(b.numMutations("FFFFFFFF", "AACCGGTT"));
		validateInput(file);
	}
	
	
	public static void validateInput(File file)
	{
		Bank b = new Bank();
		boolean valid = false;
		FileReader fr;
		BufferedReader textReader;// = new BufferedReader(fr);
		try{

			fr = new FileReader(file);
			textReader = new BufferedReader(fr);
			int numLine=0;
			String newLine =textReader.readLine();
			while(newLine!=null)
			{
				newLine=textReader.readLine();
				String [] startEndArr = newLine.split(":");
				System.out.println(b.numMutations(startEndArr[0],startEndArr[1]));
				System.out.println(startEndArr[0] + " "+ startEndArr[1]);
			}
			 valid = true;
			textReader.close();
			fr.close();	

		}
		catch(FileNotFoundException fnfe)
		{
			valid=false;
			fnfe.printStackTrace();
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		catch(IOException e){
			valid=false;
			e.printStackTrace();
		}
	

	}
}
