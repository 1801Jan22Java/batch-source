package com.revature.codechallenge1;

import java.util.ArrayList;

import com.revature.codechallenge1.MinimumMutation;

public class Driver {

	public static void main(String[] args) {
		
		ArrayList<String> bank = new ArrayList<>();
		bank.add("AACCGGTA");
		bank.add("AACCGCTA");
		bank.add("AAACGGTA");
		
		
		MinimumMutation m = new MinimumMutation("AACCGGTT","AAACGGTA", bank);
		
		System.out.print("Minimum Mutations from "+m.getStart()+" to "+m.getEnd()+": ");
		System.out.println(m.checkMutation(m.getStart(), m.getEnd(), m.getBank()));
		
		
	}
}
