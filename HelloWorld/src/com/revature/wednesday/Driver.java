package com.revature.wednesday;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {

		String[] members1 = {"Calder","Kiera","Chad"};
		Batch b1 = new Batch("1801Jan22","Java",members1);
		
		System.out.println(b1.hashCode());
		
		String[] members2 = {"Matt","Conan","Sungkwon"};
		Batch b2 = new Batch("1801Jan22","Java",members2);
		
		System.out.println(b2.hashCode());
		
		System.out.println(b1.equals(b2));
		
		funWithArrays();

	}
	
	public static void funWithArrays() {
		
		//ways to declare arrays
		int[] intArray1 = {5,6,7};
		int[] intArray2 = new int[7];
		int intArray3[] = new int[7]; //legal but horrible 
		
		System.out.println(intArray1.toString());
		//use the Arrays utility class for useful methods
		//also has a sort, search, et cetera... 
		System.out.println(Arrays.toString(intArray1));
		
		//not limited to one dimension
		int[][] intArray4 = {{1,2,3},{4,5,6},{7,8}};
		int[][] intArray5 = new int[3][4];
		System.out.println(intArray4.toString());
		System.out.println(Arrays.toString(intArray4));
		
		for(int[] i : intArray4){//int i=0; i<intArray4.length; i++){
			
			/*for (int j=0;j<intArray4[i].length; j++){
				System.out.print(intArray4[i][j]+" ");
			}*/
			System.out.println(Arrays.toString(i));
			System.out.println();
		}
		
		//throws ArrayIndexOutOfBounds exception
		System.out.println(intArray1[5]);
		
		
	}

}
