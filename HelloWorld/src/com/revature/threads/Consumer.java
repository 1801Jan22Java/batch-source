package com.revature.threads;

public class Consumer implements Runnable {

	private Basket basket;

	public Consumer(Basket b) {
		this.basket = b;
	}

	@Override
	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			value = basket.get();
			System.out.println(Thread.currentThread().getName() + " got " + value);

		}

	}

}
