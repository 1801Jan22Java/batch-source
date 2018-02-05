package com.revature.oop;

public class FunWithOOP 
{

	public static void main(String[] args) 
	{
		// create a new Animal
		Animal a1 = new Animal();
		System.out.println(a1.toString());
		
		// polymorphic instance method: toString
		Object fluffy2 = new Animal(); // implicit upcasting
		// fluffy2.setName(); //does not work because the compiler only knows that fluffy2 is an Object, but
		// at compile time, knows it's an Animal.
		// need to cast
		//((Animal) fluffy2).setName("fluffy2"); //produces an error
		// there is no implicit downcasting
		// cannot refer to Animal as an Object, but you can refer to Object as an Animal
		System.out.println(fluffy2.toString());
		
		//at compile time, the declared type is checked.
		//casts can work (at compile time) up or down the inheritance tree
		Object fluffy3 = new Object();
		//((Animal) fluffy3).setName("fluffy3");
		// will receive a "ClassCastException
		//at runtime, the actual type is checked
		
		Animal cat = new Cat("Katherine", 1);
		Animal cat2 = new Cat("Pietro", 1);
		Animal dog = new Dog(); //words because Animal has a default constructor
		
		//ARRAYS
		/*
		 * Elements must be the same type, length must be specified
		 * length is immutable (contiguous block of memory is allocated)
		 * jaa.util.Arrays (note the s) for useful methods
		 * all elements are set to default value for that data type
		 */
		Animal[] animals = new Animal[3];
		animals[0] = cat;
		animals[1] = cat2;
		animals[2] = dog;
		
		// change the static field for ALL instances of Dog
		Dog.dogLatinName = "Doggus dogis";
		
		for(int i=0; i < animals.length; i++)
		{
			animals[i].makeNoise();
			if(animals[i] instanceof Cat)
				System.out.println(Cat.catLatinName);
			if(animals[i] instanceof Dog)
				System.out.println(Dog.dogLatinName);
		}
				
	}
}
