import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class Mutations {

	public int mutation(Reader stream) {

		Scanner scan = new Scanner(stream);

		String start = scan.next();

		String end = scan.next();

		ArrayList<String> bank = new ArrayList<>();
		StringBuilder currentMutation = new StringBuilder(start);
		int numMutations = 0;

		if (start.equals(end)) {
			return numMutations;
		}

		while (scan.hasNext()) {
			bank.add(scan.next());

		}
		scan.close();

		if (bank.size() == 0 || !bank.contains(end)) {
			return -1;
		}
		for (String str : bank) {
			for (int i = 0; i < currentMutation.length(); i++) {
				if (currentMutation.charAt(i) != str.charAt(i)) {
					currentMutation.replace(i, i + 1, "" + str.charAt(i));
					numMutations++;
					break;
				}
			}
		}

		if (!currentMutation.toString().equals(end)) {
			return -1;
		}

		return numMutations;
	}

}
