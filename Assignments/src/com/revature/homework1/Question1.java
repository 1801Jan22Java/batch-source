package com.revature.homework1;

/* Created by: Jeffrey Rubi
 * Date: 23 January 2018
 * Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
 */

public class Question1 {

	public static void main(String[] args) {
		// declared, initialized an int type array;
		int[] testArray = {1,0,5,6,3,2,3,7,9,8,4};
		bubble(testArray);
		// print it.
		for(int i = 0; i < testArray.length; i++) {
			System.out.print(testArray[i] + " ");
		} // end for
	} // end main()
	
	public static void bubble(int[] toProcess) {
		/* Marker while array is not sorted, this will be 'true' until 'nextPass' is not 
		 * needed. If 'nextPass' is not needed set to false.
		 */
		boolean nextPass = true;
		
		for(int j = 1; j < toProcess.length && nextPass; j++) {
			// When array is sorted, set 'nextPass' to 'false'.
			nextPass = false;
			for(int i = 0; i < toProcess.length - j; i++) {
				if(toProcess[i] > toProcess[i+1]) {
					// Perform swap
					int temp = toProcess[i];
					toProcess[i] = toProcess[i+1];
					toProcess[i+1] = temp;
					
					// Swap occurred so 'nextPass' still 'true'
					nextPass = true;
				} // end if
			} // end for
		} // end for
	} // end bubble()

} // end class
