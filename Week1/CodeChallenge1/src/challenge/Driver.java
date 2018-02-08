package challenge;

import java.util.ArrayList;

/**
 * 
 * @author Eric
 *
 */
public class Driver {

	public static void main(String[] args) {
		ArrayList<String> genes = new ArrayList<String>();
		genes.add("AACCGGTA");
		genes.add("AACCGCTA");
		genes.add("AAACGGTA");
		GeneMutationEvaluator g = new GeneMutationEvaluator("AACCGGTT", "AAACGGTA", genes);
		System.out.println(g.minNumMutations());
	}

}
