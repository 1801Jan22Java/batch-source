package thingBuilding;

public class ScannerCalculator {

	
	
	
	
	//without Generics
	// compiles but throws exception if non Double Number is passed in
	// or returned
	public Number addWithoutGenerics(Number n1,Number n2)
	{
		return (Double)n1+(Double)n2;
	}
	
	//with generics
	
	public static <T> Number addWithGenerics(T n1, T n2)
	{
		Number result =null;
		
		if(n1 instanceof Double && n2 instanceof Double)
		{
			  result = ((Double) n1).doubleValue()+((Double)n2).doubleValue();
		}
		return result;
	}
	
	
	public static void main(String [] args)
	{
		Double a=(Double)addWithGenerics(5,6.8);
		System.out.println(a);
	}
}
