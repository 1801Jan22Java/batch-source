package com.revature.threads;

public class ProducerConsumer {

	public static void main(String[] args) {
		
		Basket b = new Basket();
		Runnable producerJob = new Producer(b);
		Runnable consumerJob = new Consumer(b);
		Thread producerWorker = new Thread(producerJob, "PRODUCER");	// overloaded constructor
		Thread consumerWorker = new Thread(consumerJob, "CONSUMER");
		producerWorker.start();
		consumerWorker.start();
	}
}



class Basket {
	private int contents;
	private boolean available = false;

	// grab all stuff in basket if there is something in it
	public synchronized int get() {
		int gotten = 0;
		while(!available) {
			System.out.println("\t\t" + Thread.currentThread().getName() + " is waiting"); // current thread to access current thread
			try {
				wait();	// pauses thread until notified
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gotten = contents;
		contents = 0;
		available = false;		// set basket back to empty if contents are retrieved
		notifyAll();			// causes threads on wait to run again
		return gotten;
	}
	
	public synchronized void put(int value) {
		while (available) {
			try {
				System.out.println("\t\t" + Thread.currentThread().getName() + "");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		contents = value;
		available = true;
		notifyAll();
	}
}

class Producer implements Runnable {

	private Basket basket;
	
	public Producer (Basket b)
	{
		this.basket = b;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			// could also use a random value
			int toPut = (int)(Math.random()*1000);
			basket.put(toPut);
			System.out.println(Thread.currentThread().getName() + " put " + toPut);
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Consumer implements Runnable {
	private Basket basket;
	int value;
	
	public Consumer (Basket b)
	{
		this.basket = b;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {

			value = basket.get();
			System.out.println(Thread.currentThread().getName() + " got " + value);
		}
	}
}
