package com.revature.codeChallengeOne;

public class GeneBank {
	public GeneBank(Gene[] bank) {
		super();
		this.bank = bank;
		size = 0;
	}

	public GeneBank(int count) {
		super();
		this.bank = new Gene[count];
		size = 0;
	}
	private static int size;
	private Gene[] bank;

	public boolean isValid() {
		for(int i = 0; i < size; i++) {
			if(!bank[i].isValid())
				return false;
		}
		return true;
	}
	public void add(Gene g) {
		bank[size] = g;
		++size;
	}
	
	public int getSize() {
		return size;
	}
	
	public Gene[] getBank() {
		return bank;
	}

	public void setBank(Gene[] bank) {
		this.bank = bank;
	}
}
