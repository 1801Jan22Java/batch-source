package com.revature.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Challenge {
	
	public static int mutator(String bank, String gene_start,String gene_end) {
		String [][] mismatches = new String[gene_start.length()][1];
		String[]bank2 = bank.split(",");
		String gene_start2 = bank2[bank2.length-2];
		String gene_end2 = bank2[bank2.length-1];
		int mutations = -1;
		boolean same = true;
		int last_mutation = 0;
		
		/*for(int l = 0; l<= gene_start.length()-1;l++) {
			if(gene_start.charAt(l) != gene_end.charAt(l)) {
				mutations += 1;
				same = false;
			}
			
		}*/
		
		for(String h : bank2) {
			System.out.println(h);
		}
		
		for(int l = 0; l< gene_start.length();l++) {
			
			if(gene_start.charAt(l) != gene_end.charAt(l)) {
				
				for(int n = 0;n<bank2.length;n++) {
					//System.out.println("got here");
					for(int m = last_mutation; m<gene_start.length();m++) {
						if(gene_start.charAt(l) != bank2[n].charAt(m)) {
							//System.out.println("got here");
							
							System.out.println("m is : "+bank2[n].charAt(m)+" l is : "+l );
							if(m == l) {
								System.out.println("got here");
								mutations+=1;
							}
							else{
								break;
							}
						}
					}
				}
				//mismatches[l][0] = mismatches[l][gene_end.charAt(l)];
			}
		}
		
		if(same == true) {
			return 0;
		}else {
			return mutations+1;
		}
		
		
	}
	
	public static String getBank() {
		
		String bank = null;
		
		File file = new File("Genes.txt");
		try {
			Scanner in = new Scanner(new BufferedReader(new FileReader("Genes.txt")));
			while(in.hasNextLine()) {
				bank += in.nextLine();
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bank;
	}
	
	public static void main(String[] args) {
		getBank();
		
		
		//System.out.print(mutator(getBank(),"AACCGGTT","AAACGGTA"));
		String s = null;
		Object p = new Object();
		
		boolean b1 = false;
		boolean b2 = false;
		
		if(b1 = b2= b1) {
			System.out.println("worked");
		}
		//System.out.println(p);
		//System.out.println(s+ "fjdlsj");
		
			//System.out.println(mutator(getBank()));
	}

}
