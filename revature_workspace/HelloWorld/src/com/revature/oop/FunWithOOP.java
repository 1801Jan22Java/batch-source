package com.revature.oop;

public class FunWithOOP {
	
	public static void main(String [] args)
	{
		Animal fluffy = new Animal();
		System.out.println(fluffy.toString());
		
		// polymorphic instance method : toString
		
		
		Object fluffy2= new Animal();
		//Animal is a subtype of object, and object can thus be instantiated as an animal.
		// fluffy2.setName() // This doesn't work.  fluffy2 is declared as an object
		System.out.println(fluffy2.toString());
		
		((Animal) fluffy2).setName("Fluffy2");
		//In order to access the Animal methods, we need to cast fluffy2 as an Animal.
		//We can have implicit upcasting but not implicit downcasting
		System.out.println(fluffy2.toString());
		
		// At compile time the declared type is checked.
		// casts can work [at compile time] up or down the inheritance tree in
		// any direction
		
		Object fluffy3 = new Object();
//		((Animal) fluffy3).setName("Sparkles-fluffy3");//About to throw a ClassCastException
		//To the compiler, this looks like an animal
	//	System.out.println(fluffy3.toString());  //Throws a ClassCastException at runtime
		
		Cate c1 = new Cate(8,"Francois");
		Cate c2 = new Cate(7,"Mitterand");
		Doge d1 = new Doge();
		Doge d2 = new Doge();
		
		/*
		 * Arrays:
		 * Elements must be the same type, length must be specified
		 * Length is immutable (contiguous block of memory is allocated)
		 * java.util.Arrays (note the s) for useful methods
		 * All elements are set to default value for that data type
		 * 
		 * */
		
		Animal [] animalArray = new Animal[3];
		animalArray[0] =c1;
		animalArray[1]=c2;
		animalArray[2]=d1;
		for (int i = 0; i<animalArray.length;i++)
		{
			animalArray[i].makeNoise();
			
		}
		
		//Best practices : Refer to static members via the class.
		System.out.println(Cate.catLatinName);
		System.out.println(d1.latinName);
		d2.setName("Fre");
		System.out.println(d1.toString());
		System.out.println(d2.getName());
		
		Animal a = new Doge();
		System.out.println(a.latinName);  // returns Animalis.
		//We don't get overriding in variables.  
		System.out.println(((Doge)a).latinName);
		
		
		
		
	}

}
