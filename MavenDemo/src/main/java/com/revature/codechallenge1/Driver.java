package com.revature.codechallenge1;

import java.util.ArrayList;
import java.util.List;

import com.revature.codechallenge1.MutateQuery;

public class Driver {

	public static void main(String[] args) {
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		String[] bankArr = {"AACCGGTA", "AACCGCTA", "AAACGGTA", "AAACGCTA"};
		List<String> bank = new ArrayList<String>();
		for (String s : bankArr) {
			bank.add(s);
		}
		
		System.out.println(MutateQuery.query(start, end, bank));
	}

}
