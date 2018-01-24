package com.revature.oop;

public class FunWithOop {

	public static void main(String[] args) {
		
		
		// create a new Animal
		Animal fluffy = new Animal();
		
		System.out.println(fluffy.toString());
		
		// polymorphic instance method: toString
		Object fluffy2 = new Animal();			// implicit upcasting
		
		//fluffy2.setName("fluffy2"); 			// it doesn't work
		
		((Animal) fluffy2).setName("fluffy2");	// in order to access the Animal methods, we need to cast 
		// to implicit downcasting
		// but! when we call fluffy2.toString, we get the Animal version
		
		System.out.println(fluffy2.toString()); 	// it works cus Object has 'toString' but get/set doesn't work  cus get/set is in only Animal.
		
		// at compile time, the declared type is checked.
		// casts can work (at compile time) up or down the inheritance tree
		
		
		Object fluffy3 = new Object();
		//((Animal) fluffy3).setName("fluffy3"); 	// this throws a ClassCastException. At runtime, the actual type is checked.
		
		
		
		Cat c1= new Cat(8, "Paul");
		Cat c2 = new Cat(7, "Peter");
		Dog d1 = new Dog();
	
		/*
		 *  Array;
		 *  Elements must be the same type, length must be specified
		 *  length is immutable (contigous block of memory is allocated)
		 *  java.util.Arrays (note the s) for useful methods
		 *  all set elements are set to default value for that data type
		 */
		
		Animal[] animalArray = new Animal[3];
		animalArray[0] = c1;
		animalArray[1] = c2;
		animalArray[2] = d1;
		for (int i = 0 ; i < animalArray.length ; i++) {
			animalArray[i].makeNoise();
		}
		
		// best practices : refer to static members via the class
		System.out.println(Cat.catinName);
		
		Dog d2 = new Dog();
		
		// this will change the static field for ALL INSTANCES OF DOG
		// d2.latinName = "new latin name since it's not final";
		System.out.println("d1: " + d1.latinName);
		System.out.println("d2: " + d2.latinName);
		
		// fun with shadowing
		d2.setName("fido");
		System.out.println(d2.getName());
		
		Animal a = new Dog();
		System.out.println(a.latinName); 		// Animal LatinName return
		
		System.out.println(((Dog) a).latinName);
	}
}
