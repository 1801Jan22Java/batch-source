package com.revature.threads;

public class ProducerConsumer {

	public static void main(String[] args) {
		
		Basket b = new Basket();
		Runnable producerJob = new Producer(b);
		Runnable consumerJob = new Consumer(b);
		
		//Have to create a thread and pass in the runnable object.
		Thread producerWorker = new Thread(producerJob, "PRODUCER");
		Thread consumerWorker = new Thread(consumerJob, "CONSUMER");
		producerWorker.start();
		consumerWorker.start();
		
	}
	
}

class Basket{
	private int contents; 
	private boolean available = false;
	
	public synchronized int get() {
		int gotten = 0;
		while(!available) {
			try {
				System.out.println("\t\t" + Thread.currentThread().getName() + " is waiting");
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		gotten = contents;
		contents = 0;
		available = false;
		notifyAll();
		return gotten;
	}
	
	public synchronized void put(int value) {
		while(available) {
			try {
				System.out.println("\t\t" + Thread.currentThread().getName() + " is waiting");
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		contents = value;
		available = true;
		notifyAll();
		
	}
}

class Producer implements Runnable{
	
	private Basket basket;
	
	public Producer() {
		super();
	}
	
	public Producer(Basket b) {
		this.basket = b;
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			int toPut = (int) (Math.random()*1000);
			basket.put(toPut);
			System.out.println(Thread.currentThread().getName() + " put " + toPut);
			try {
				Thread.sleep((int) (Math.random()*100));
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Consumer implements Runnable{
	private Basket basket;
	
	public Consumer() {
		super();
	}
	
	public Consumer(Basket b) {
		this.basket = b;
	}

	@Override
	public void run() {
		int value = 0;
		for(int i = 0; i < 10; i++) {
			// Could also use a random value
			value = basket.get();
			System.out.println(Thread.currentThread().getName() + " got " + value);
		}
	}
}