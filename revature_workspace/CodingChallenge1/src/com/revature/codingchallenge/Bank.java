package com.revature.codingchallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bank {
	static ArrayList<String> bankList = new ArrayList<String>();
	static String[] bankArray;
	static char[] validChars = {'G','C','T','A'};

	public void addSequence(String sequence)
	{
		bankList.add(sequence);
	}

	public String[] convertToArray()
	{
		String [] bankArray = new String[bankList.size()];
		for(int i =0;i<bankArray.length;i++)
		{
			bankArray[i]=bankList.get(i);
		}
		return bankArray;
	}

	public boolean sequenceExists(String sequence)
	{
		String [] bankArray= convertToArray();
		boolean exists =false;
		for(int i = 0; i<bankArray.length;i++)
		{
			if(sequence.equals(bankArray[i]))
			{
				exists=true;
				break;
			}
		}
		return exists;
	}

	public int numMutations(String startSequence,String endSequence)
	{

		int numMutations=0;
		if(!sequenceExists(endSequence))
		{
			System.out.println("That sequence does not exist");
			numMutations=-1;
		}
		else
		{
			char[] start = startSequence.toCharArray();
			char[] end = endSequence.toCharArray();

			for(int i =0;i<start.length;i++)
			{
				if (start[i]!=end[i])
				{
					numMutations++;
				}
			}
		}
		return numMutations;
	

	}



}
