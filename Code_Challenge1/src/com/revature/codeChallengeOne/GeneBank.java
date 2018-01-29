package com.revature.codeChallengeOne;

public class GeneBank {
	public GeneBank(Gene[] bank) {
		super();
		this.bank = bank;
	}

	public GeneBank(int count) {
		super();
		this.bank = new Gene[count];
	}
	public static int size;
	private Gene[] bank;

	public void add(Gene g) {
		bank[size] = g;
		++size;
	}
	
	public Gene[] getBank() {
		return bank;
	}

	public void setBank(Gene[] bank) {
		this.bank = bank;
	}
}
