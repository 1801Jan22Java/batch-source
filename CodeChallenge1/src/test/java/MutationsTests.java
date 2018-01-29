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
	
	public void testGoodRunThrough() {
		String input = "AAAAA\nCCCCC\nAAAAC\nAAACC\nAACCC\nACCCC\nCCCCC";
		StringReader rdr = new StringReader(input);
		Mutations mutations = new Mutations();
		
		int rtnVal = mutations.mutation(rdr);
		
		assertEquals(5, rtnVal);
	}
	
	public void testNoEndInBank() {
		String input = "AAAAA\nCCCCC\nAAAAC\nAAACC\nAACCC\nACCCC";
		StringReader rdr = new StringReader(input);
		Mutations mutations = new Mutations();
		
		int rtnVal = mutations.mutation(rdr);
		
		assertEquals(-1, rtnVal);
	}
	
	public void testNoWayToGetToEnd() {
		String input = "AAAAA\nCCCCC\nAAAAC\nAAACC\nAACCC\nCCCCC";
		StringReader rdr = new StringReader(input);
		Mutations mutations = new Mutations();
		
		int rtnVal = mutations.mutation(rdr);
		
		assertEquals(-1, rtnVal);
	}
	
	

}
