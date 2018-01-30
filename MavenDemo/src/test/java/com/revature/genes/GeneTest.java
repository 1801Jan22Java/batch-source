package com.revature.genes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

import com.revature.codechallenge1.MutateQuery;

public class GeneTest {
	
	@Test
	public final void testExample() {
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		String[] bankArr = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		List<String> bank = new ArrayList<String>();
		for (String s : bankArr) {
			bank.add(s);
		}
		
		Assert.assertEquals(MutateQuery.query(start, end, bank), 2);
	}
	
	@Test
	public final void differentExample() {
		String start = "AACCGGTG";
		String end = "GAACGCTA";
		String[] bankArr = {"AACCGGTA", "AACCGCTA", "AAACGGTA", "AAACGCTA"};
		List<String> bank = new ArrayList<String>();
		for (String s : bankArr) {
			bank.add(s);
		}
		
		Assert.assertEquals(MutateQuery.query(start, end, bank), 4);
	}
	
	@Test
	public final void noPathTest() {
		String start = "AAAAAAAA";
		String end = "GGGGGGGG";
		String[] bankArr = {"AACCGGTA", "AACCGCTA", "AAACGGTA", "AAACGCTA"};
		List<String> bank = new ArrayList<String>();
		for (String s : bankArr) {
			bank.add(s);
		}
		
		Assert.assertEquals(MutateQuery.query(start, end, bank), -1);
	}
	
	@Test
	public final void testStartInBank() {
		String start = "AACCGGTA";
		String end = "AAACGGTA";
		String[] bankArr = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		List<String> bank = new ArrayList<String>();
		for (String s : bankArr) {
			bank.add(s);
		}
		
		Assert.assertEquals(MutateQuery.query(start, end, bank), 1);
	}

}
