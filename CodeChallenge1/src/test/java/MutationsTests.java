import static org.junit.Assert.*;

import java.io.StringReader;
import org.junit.Test;

public class MutationsTests {

	@Test
	public void testEqualStartAndEnd() {
		String input = "AACCGGTT\nAACCGGTT";
		StringReader rdr = new StringReader(input);
		Mutations mutations = new Mutations();
		
		int rtnVal = mutations.mutation(rdr);
		
		assertEquals(0, rtnVal);
	}

}
