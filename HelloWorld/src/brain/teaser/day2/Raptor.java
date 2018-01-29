package brain.teaser.day2;

class Raptor extends Bird 
{
	static
	{
		System.out.println("r1");
	}
	public Raptor()
	{
		System.out.println("r2");
	}
	{
		System.out.println("r3");
	}
	static 
	{
		System.out.println("r4");
	}
}
