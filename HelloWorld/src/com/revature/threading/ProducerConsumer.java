package com.revature.threading;

public class ProducerConsumer 
{

	public static void main(String[] args) 
	{
		Basket b = new Basket();
		Runnable producer = new Producer(b);
		Runnable consumer = new Consumer(b);
	}

}
class Basket
{
	private static int contents;
	private static boolean available = false;
	
	public synchronized int get()
	{
		while(!available)
		{
			try
			{
				System.out.println("\t\t"+Thread.currentThread().getName()+" is waiting");
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		this.available = false;
		notifyAll();
		return contents;
	}
	public synchronized static void put(int value)
	{
		while(available)
		{
			try
			{
				System.out.println("\t\t"+Thread.currentThread().getName()+" is waiting");
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		contents = value;
		available = true;
		notifyAll();
	}
}
class Producer implements Runnable
{
	static Basket b;
	public Producer(Basket b)
	{
		this.b = b;
	}

	@Override
	public void run() 
	{
		for(int i = 0; i < 10; i++)
		{
			b.put(i);
			System.out.println(Thread.currentThread().getName()+" put "+i);
			try
			{
				Thread.sleep((int)(Math.random()*100));
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
class Consumer implements Runnable
{
	static Basket b;
	public Consumer(Basket b) {
		this.b=b;
	}

	@Override
	public void run() 
	{
		int value = 0;
		for(int i =0; i<10 ; i++)
		{
			
		}
	}
	
}
