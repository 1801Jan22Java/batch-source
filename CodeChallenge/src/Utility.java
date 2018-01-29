
public class Utility {

	public static int bankMutate(String startGene, int choice)
	{
		//variables to hold the number of mutations
		//as well as character arrays for the gene bank
		int mutations = 0;
		char[] bank1 = {'A','A','C','C','G','G','T','A'};
		char[] bank2 = {'A','A','C','C','G','G','C','T','A'};
		char[] bank3 = {'A','A','C','G','G','T','A'};
		
		//converts the entered string to a character array
		char[] ch1 = startGene.toCharArray();
		
		//based on the end point chosen in the bank, the switch statement alters
		//the entered string to match the end string
		switch(choice)
		{
		//if user chose the first option of an end gene string
		case 1:
		{
			for(int i = 0; i < 8; i++)
			{
				if(ch1[i] != bank1[i])
				{
					ch1[i] = bank1[i];
					++mutations;
				}
			}			
			return mutations;
		}
		//if user chose the second option of an end gene string
		case 2:
		{
			for(int i = 0; i < 8; i++)
			{
				if(ch1[i] != bank2[i])
				{
					ch1[i] = bank2[i];
					++mutations;
				}
			}			
			return mutations;	
		}
		//if the user chose the third option of end gene string
		case 3:
		{
			for(int i = 0; i < 8; i++)
			{
				if(ch1[i] != bank3[i])
				{
					ch1[i] = bank3[i];
					++mutations;
				}
			}
			return mutations;
		}
		default:
		{
			System.out.println("You did not enter a valid number");
			return 0;
		}
		}	
	
	}
	
}
