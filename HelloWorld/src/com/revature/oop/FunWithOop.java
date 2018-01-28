// Date: 1/23/2018

package com.revature.oop;

public class FunWithOop {

	public static void main(String[] args) {
		
		// create a new Animal
		Animal fluffy = new Animal();
		
		System.out.println(fluffy.toString());
		
		// polymorphic instance method: toString
		// At compile time the compiler only knows 
		Object fluffy2 = new Animal();				// implicit upcasting
		((Animal) fluffy2).setName("fluffy");
		// In order to access the Animal methods, we need to cast
		// No implicit downcasting
		// But! when we call fluffy.toString, we get the Animal version
		System.out.println(fluffy2.toString());
		
		// For fluffy2 only Object methods are visible 
		// but fluffy2 still has Animal implementations
		
		// At compile time, the declared type is checked
		// Casts can work (at compile time) up or down the inheritance tree
		Object fluffy3 = new Object();
		// ((Animal) fluffy3).setName("fluffy3"); // this gives a ClassCastException 
		// At runtime, the actual type is checked
		
		
		Cat cat1 = new Cat(8, "Paul");
		Cat cat2 = new Cat(7, "Peter");
		Dog dog1 = new Dog();
		
		/*
		 * Arrays:
		 * -Elements must be the same as the declared type of the array
		 *  or an inherited class from the declared type of the array
		 * , length must be specified
		 * -Length is immutable (Contiguous block of memory is allocated)
		 * -java.util.Arrays (Note the s) for useful methods
		 * -All elements are set to the default value for that data type
		 */
		
		Animal[] animalArray = new Animal[3];
		animalArray[0] = cat1; 
		animalArray[1] = cat2;
		animalArray[2] = dog1;
		
		for (int i = 0; i < animalArray.length; i++) {
			animalArray[i].makeNoise();
		}
		
		// Best practices: refer to static members via the class
		System.out.println(Cat.catinName);
		
		Dog dog2 = new Dog();
		
		// this will change the static field for ALL INSTANCES OF DOG
		// dog2.latinName = "doggus doggus";
		
		System.out.println(dog1.latinName);
		System.out.println(dog2.latinName);
		
		
		// fun with shadowing
		dog2.setName("fido");					
		System.out.println(dog2.getName());		// calling dog animal, not dog animal
		
		Animal a = new Dog();					// do not get overriding of data fields
		System.out.println(a.latinName);		// data fields are going to be of the declared type,
												// unless the object is casted back down
	}
}
