package com.revature.threads;

public class Producer implements Runnable {

	private Basket basket;

	public Producer(Basket b) {
		this.basket = b;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			int toPut = (int) (Math.random() * 1000);
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
