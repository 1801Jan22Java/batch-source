package com.revature.threads;



public class ProducerConsumer {

	public static void main(String[] args) {
		Basket b = new Basket();
		
		Producer prod = new Producer(b);
		Consumer cons = new Consumer(b);
		Thread producerWorker = new Thread(prod,"PRODUCER");
		Thread consumerWorker = new Thread(cons,"CONSUMER");
		producerWorker.start();
		consumerWorker.start();


	}

}

class Basket {
	private int contents;
	private boolean available=false;

	public synchronized int get() {
		while(!available)
		{
			try{
				System.out.println("\t\t"+Thread.currentThread().getName()+ " is waiting");
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		notifyAll();
		int gotten=0;
		gotten=contents;
		contents=0;
		available=false;
		return gotten;
	}

	public synchronized void put(int value)
	{
		while(available)
		{
			try{
				System.out.println("\t\t"+Thread.currentThread().getName()+ " is waiting");
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		contents=value;
		available=true;
		notifyAll();
	}


}

class Producer implements Runnable {
	private Basket basket;

	public Producer (Basket basket)
	{
		this.basket =basket;
	}

	@Override
	public void run(){
		for(int i =0;i<10;i++)
		{
			// Could use a random value
			int rand=(int)(Math.random()*1000);
			basket.put(rand);
			System.out.println(Thread.currentThread().getName()+" put " +rand );
			try
			{
				Thread.sleep((int) (Math.random()* 100));
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
class Consumer implements Runnable{
	private Basket basket;

	public Consumer (Basket basket)
	{
		this.basket =basket;
	}

	@Override
	public void run(){
		int value = 0;
		for(int i =0;i<10;i++)
		{
			// Could use a random value
			value = basket.get();
			System.out.println(Thread.currentThread().getName()+" got " + value);

		}
	}
}