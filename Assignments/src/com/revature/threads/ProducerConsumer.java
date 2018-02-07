package com.revature.threads;

public class ProducerConsumer {

	public static void main(String[] args) {
		Basket b = new Basket();
		Runnable producerJob = new Producer(b);
		Runnable consumerJob = new Consumer(b);
		
		Thread producerThread = new Thread(producerJob,"PRODUCER");
		Thread consumerThread = new Thread(consumerJob,"CONSUMER");
		
		producerThread.start();
		consumerThread.start();
	}

}

class Basket {
	private int contents;
	private boolean available = false;

	public synchronized int get() {
		int gotten = 0;
		while (!available) {
			try {
				System.out.println("\t\t" + Thread.currentThread().getName() + " is waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		gotten = contents;
		contents = 0;
		available = false;
		notifyAll(); // notifies the waiting threads?
		return gotten;
	}

	public synchronized void put(int value) {

		while (available) {
			try {
				System.out.println("\t\t" + Thread.currentThread().getName() + " is waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		available = true;
		contents = value;
		notifyAll();
	}
}

class Producer implements Runnable {

	private Basket basket;

	public Producer(Basket b) {
		this.basket = b;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			int toPut = (int) (Math.random()*1000) ;
			basket.put(toPut);
			System.out.println(toPut);
			System.out.println(Thread.currentThread().getName() + " put " + toPut);
			try {
				Thread.sleep((int) Math.random() * 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {

	private Basket basket;

	public Consumer(Basket b) {
		this.basket = b;
	}

	@Override
	public void run() {
		int item;
		for (int i = 0; i < 10; i++) {
			item = basket.get();
			System.out.println(Thread.currentThread().getName() + " got " + item);
		}

	}
}