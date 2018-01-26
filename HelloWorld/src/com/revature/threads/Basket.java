package com.revature.threads;

public class Basket {
	
	private int contents;
	private boolean available = false;
	
	public synchronized int get(){
		int gotten = 0;
		while (!available){
			try {
				System.out.println("\t\t"+Thread.currentThread().getName()+" is waiting");
				wait();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		gotten = contents;
		contents = 0;
		available = false;
		notifyAll();
		return gotten;
	}
	
	public synchronized void put(int value){
		while(available){
			try {
				System.out.println("\t\t"+Thread.currentThread().getName()+" is waiting");
				wait();
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		contents = value;
		available = true;
		notifyAll();
	}

}
