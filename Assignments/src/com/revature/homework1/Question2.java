package com.revature.homework1;


// Print out the first 25 fibonacci numbers starting at 0
public class Question2 {
	public static void main(String[] args) {
		fiboGen(25);
	}
	
	// Looping strategy for fibonacci sequence
	public static void fiboGen(int count) {
		int prev=0;
		int next=0;
		
		// Temporary variable to hold value of next
		// before next gets added onto the previous number
		int temp=0;
		while(count>0) {
			temp=next;
			next+=prev;
			prev=temp;
			System.out.print(prev+" ");
			
			// The fibonacci sequence cannot start without incrementing the next
			if(prev==0&&next==0) {
				next++;
			}
			count--;
		}
	}
}
