import java.util.ArrayList;

//James Whitten


public class GeneChecking {

	private int mutationCount;
	
	//Checks number of mutations from start to end
	public ArrayList<Integer> checkMutations(String start, String end)
	{
		ArrayList<Integer> mutationAreas = new ArrayList();
		for (int i = 0; i < start.length(); i++)
		{
			if (start.charAt(i) != end.charAt(i))
			{
				mutationAreas.add(i);
			}
		}
		
		return mutationAreas;
	}
	
	//Checks types of mutations from start to end
	public ArrayList<Character> mutationTypes(String end, ArrayList<Integer> mutationAreas)
	{
		ArrayList<Character> mutationTypes = new ArrayList();
		for (int i = 0; i < mutationAreas.size(); i++)
		{
			mutationTypes.add(end.charAt(i));
		}
		
		return mutationTypes;		
	}
	
	//Converts a String to an ArrayList
	public ArrayList<Character> makeTempBank(String bankString)
	{
		ArrayList<Character> tempBank = new ArrayList();
		for (int i = 0; i < bankString.length(); i++)
		{
			tempBank.add(bankString.charAt(i));
		}
		return tempBank;
	}
	
	//Counting mutations from start to end using a bank
	public int mutationCounting(String start, String end, ArrayList<String> bank)
	{
		ArrayList<Integer> mutAreas = new ArrayList();
		ArrayList<Character> mutTypes = new ArrayList();
		ArrayList<String> tempBank = new ArrayList();
		mutAreas = checkMutations(start, end);
		int totalMutations = mutAreas.size();
		
		if (totalMutations == 0)
			return 0;
		else 
		{
			mutTypes = mutationTypes(end, mutAreas);
			for (int i = 0; i < mutAreas.size(); i++)
			{
				for (int j = 0; j < bank.size(); j++)
				{
					ArrayList<Character> tempBankItem = new ArrayList();
					tempBankItem = makeTempBank(bank.get(j));
					tempBankItem.set(mutAreas.get(i), mutTypes.get(i));
					
				}
			}
			
		}
		
		
		return 0;
	}
	
	
}
