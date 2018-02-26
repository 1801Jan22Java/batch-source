package challenge;

import java.util.ArrayList;
import java.util.Iterator;

public class GeneMutationEvaluator
{
	String start;
	String end;
	ArrayList<String> bank;

	public GeneMutationEvaluator(String start, String end, ArrayList<String> bank) 
	{
		this.start = start;
		this.end = end;
		this.bank = bank;
	}

	public String getStart()
	{
		return start;
	}

	public void setStart(String start)
	{
		this.start = start;
	}

	public String getEnd()
	{
		return end;
	}

	public void setEnd(String end)
	{
		this.end = end;
	}

	public ArrayList<String> getBank()
	{
		return bank;
	}

	public void setBank(ArrayList<String> bank)
	{
		this.bank = bank;
	}

	public boolean isValidMutation(String gene, ArrayList<String> bank)
	{
		if(!bank.contains(gene))
			return false;
		else
			return true;
	}

	public ArrayList<Integer> indicesOfMutation(String s1, String s2)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();

		for(int i = 0; i < s1.length(); i++)
		{
			if(s1.charAt(i) != s2.charAt(i))
			{
				result.add(1);
			}
			else
				result.add(-1);
		}
		return result;
	}

	public int indexOfMutation(String s1, String s2)
	{
		int index = 0;
		boolean hasMutation = false;
		for(int i = 0; i < s1.length(); i++)
		{
			if(s1.charAt(i) != s2.charAt(i))
			{
				index = i;
				hasMutation = true;
			}
		}
		if(hasMutation)
			return index;
		else
			return 0;
	}
	
	public int numDifferences(String s1, String s2)
	{
		int counter = 0;
		for(int i = 0; i < s1.length(); i++)
		{
			if(s1.charAt(i) != s2.charAt(i))
			{
				counter++;
			}
		}
		return counter;
	}

	//determine what is the minimum number of mutations 
	//needed to mutate from "start" to "end".
	public int minNumMutations()
	{
		int result = 0;
		if(start.equals(end))
			result = 0;
		else if(bank.isEmpty())
			result = -1;
		else
		{
			//iterate through the string
			//if the curr index of start does not match
			//the curr index of end
			//increase the counter.
			//if the counter is greater than 1,
			//the mutation is not a valid mutation.
			ArrayList<Integer> startVsEnd = indicesOfMutation(start, end);
			ArrayList<String> possibleValidGenes = new ArrayList<String>();
			for(int i = 0; i < bank.size(); i++)
			{
				String curr = bank.get(i);
				ArrayList<Integer> startVsCurr = indicesOfMutation(start, curr);
				ArrayList<Integer> currVsEnd = indicesOfMutation(curr, end);
				if(numDifferences(start, curr) == 1 && startVsEnd.get(i) != -1 && startVsCurr.get(i) != currVsEnd.get(i))
					possibleValidGenes.add(curr);
			}
			result = possibleValidGenes.size();
		}
		return result;
	}
}
