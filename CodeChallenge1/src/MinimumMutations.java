import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class MinimumMutations {
	public static void findMinimumMutations(String filename) {
		// open file and read in start, end and bank strings
		File file = new File("Bank.txt");
		String start;
		String end;
		String toParse;
		String[] bank;
		String[] tempBank;
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader(file));
			start = buffRead.readLine();
			end = buffRead.readLine();
			toParse = buffRead.readLine();
			bank = toParse.split(",");
			tempBank = oneAway(start, bank);
			

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// this method checks the input string to the strings in the bank
	// and returns a stringArray of those strings which are valid mutations
	public static String[] oneAway(String currentString, String[] bank) {
		String[] oneAways = {};
		for (String s : bank) {
			int count = 0;
			for (int i = 0; i < 8; i++) {
				if (currentString.charAt(i) != s.charAt(i))
					count++;
			}
			if (count == 1) {
				Arrays.copyOf(oneAways, oneAways.length + 1);
				oneAways[oneAways.length - 1] = s;
			}
			count = 0;
		}
		return oneAways;
	}
}
