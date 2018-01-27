package com.revature.threads;

public class ProducerConsumer {
	public static void main(String[] args) {
		Basket basket = new Basket();
		Runnable producerJob = new Producer(basket);
		Runnable consumerJob = new Consumer(basket);

		Thread producerWorker = new Thread(producerJob, "PRODUCER");
		Thread consumerWorker = new Thread(consumerJob, "CONSUMER");

		producerWorker.start();
		consumerWorker.start();
	}

}


