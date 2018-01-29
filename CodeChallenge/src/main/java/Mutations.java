
public class Mutations {

	public int mutate(String startString, endString) {
		// return -1 if a null argument is passed in
		if (startString == null || endString == null) {
			return -1;
		}
		// return -1 if one of the passed in arguments does not contain 8 characters
		if (startString.length() != 8 || startString.length() != 8) {
			return -1;
		}
		
		// convert the passed in String arguments to char arrays
		char[] charStart = startString.toCharArray();
		char[] charEnd = endString.toCharArray();
		
		// iterate through charStart and charEnd to ensure all variables are characters
		for (char c : charStart) {
			if (!c.isLetter()) {
				return -1; 
			}
		}
		for (char c : charEnd) {
			if (!c.isLetter()) {
				return -1;
			}
		}
		
		// return 1 if startString and endString are the same, 
		// assuming startString is valid per instructions
		if (startString.equals(endString)) {
			return 0;
		}
		
		// bank of Strings
		String stringBank1 =  "AACCGGTA";
		String stringBank2 = "AACCGCTA";
		String stringBank3 = "AAACGGTA";
		
		char[] charBank1 = stringBank1.toCharArray();
		char[] charBank2 = stringBank2.toCharArray();
		char[] charBank3 = stringBank3.toCharArray();
		
		// counters to count similar characters, 7 required for a mutation
		// if all below 7 then return -1
		int counter1 = 0;
		int counter2 = 0;
		int counter3 = 0;
		
		String currentString = startString;
		for (int i = 0; i < startString.length(); i++) {
			if (startString[i].toString().equals(charBank[1].toString)) {
				counter1++;
			}
		}
		
	}
	
	public String compareGenes(String geneString) {
		String stringBank1 =  "AACCGGTA";
		String stringBank2 = "AACCGCTA";
		String stringBank3 = "AAACGGTA";
		
		char[] geneChar = geneString.toCharArray();
		char[] charBank1 = stringBank1.toCharArray();
		char[] charBank2 = stringBank2.toCharArray();
		char[] charBank3 = stringBank3.toCharArray();
		
		// counters to count similar characters, 7 required for a mutation
		// if all below 7 then return -1
		int counter1 = 0;
		int counter2 = 0;
		int counter3 = 0;
		
		for (int i = 0; i < geneString.length(); i++) {
			if (Character.toString(geneChar[i]).equals(Character.toString(charBank1[i]))) {
				counter1++;
			}
			if (Character.toString(geneChar[i]).equals(Character.toString(charBank2[i]))) {
				counter2++;
			}
			if (Character.toString(geneChar[i]).equals(Character.toString(charBank3[i]))) {
				counter3++;
			}
		}
		
		if (counter1 < 7 && counter2 < 7 && counter3 < 7) {
			
		}
		
		if (counter1 > 7 || counter2 > 7 || counter3 > 7) {
			
		}
		
	}
}
