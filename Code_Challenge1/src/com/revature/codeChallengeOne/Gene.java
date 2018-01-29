package com.revature.codeChallengeOne;

public class Gene {
	
	public Gene(String gene) {
		super();
		this.gene = gene;
	}

	private String gene;
	public final static int GENE_LENGTH = 8;
	
	public boolean isValid() {
		for(int i = 0; i < GENE_LENGTH; i++) {
			if((gene.charAt(i) != "A") || (gene.charAt(i) != "G") || (gene.charAt(i) != "T") || (gene.charAt(i) != "C"))
		}
	}
	
	//Overloading equals
	public boolean equals(Gene g) {
		for(int i = 0; i < GENE_LENGTH; i++) {
			if(!gene.equals(g.getGene()))
				return false;
		}
		return true;	
	}
	
	public int numberMutations(Gene g) {
		int count = 0;
		for(int i = 0; i < GENE_LENGTH; i++) {
			if(gene.charAt(i) != g.getGene().charAt(i))
				++count;
		}
		return count;
	}
	
	public Integer[] locateMutations(Gene g, int count) {
		Integer[] loc = new Integer[count];
		int j = 0;
		for(int i = 0; i < count; i++) {
			loc[i] = -1; // marker value
			// if loc[n] == -1, is not a valid mutation location
		}
		for(int i = 0; i < GENE_LENGTH; i++) {
			if(gene.charAt(i) != g.getGene().charAt(i)) {
				loc[j] = i;
				j++;
			}
		}
		return loc;
	}

	public String getGene() {
		return gene;
	}

	public void setGene(String gene) {
		this.gene = gene;
	}
	
	
	
	
}
