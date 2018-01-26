package com.revature.threads;

public class ProducerConsumer {

	public static void main(String[] args) {
		
		Basket b = new Basket();
		Runnable producerJob = new Producer(b);
		Runnable consumerJob = new Consumer(b);
		Thread producerWorker = new Thread(producerJob, "PRODUCER");
		Thread consumerWorker = new Thread(consumerJob, "CONSUMER");
		
		producerWorker.start();
		consumerWorker.start();
		
	}

}

class Basket {
	
	private int contents;				//Has some amount of stuff in it
	private boolean available = false;	
	
	public synchronized int get() {
		int gotten = 0;
		while(!available) {
			try {
				System.out.println("\t\t" + Thread.currentThread().getName() + " is waiting");
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		gotten = contents;
		contents = 0;
		
		available = false;				//
		notifyAll();
		return gotten;
	}
	
	public synchronized void put(int value) {
		while(available) {
			try {
				System.out.println("\t\t" + Thread.currentThread().getName() + " is waiting");
				wait();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		contents = value;
		available = true;	//There is a value in the basket available
		notifyAll();
	}
}

class Producer implements Runnable{

	private Basket basket;
	public Producer(Basket b) {
		this.basket = b;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			//Could also use a random value or something
			int toPut = (int)(Math.random()*1000);
			basket.put(toPut);
			System.out.println(Thread.currentThread().getName() + " put " + toPut);
			
			//Let thread sleep for random amount of time
			try {
				Thread.sleep((int)(Math.random() * 100));
				
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	
}

class Consumer implements Runnable{

	private Basket basket;
	public Consumer(Basket b) {
		this.basket = b;
	}
	
	@Override
	public void run() {
		int value = 0;
		for(int i = 0; i < 10; i++) {
			value = basket.get();
			System.out.println(Thread.currentThread().getName() + " got " + value);
			
			
		}
	}
	
}