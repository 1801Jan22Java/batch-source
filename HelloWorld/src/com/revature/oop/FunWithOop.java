package com.revature.oop;

public class FunWithOop {
	
	public static void main(String[] args)
	{
		//create a new Animal
		Animal fluffy = new Animal();
		
		fluffy.setName("Fluffy");
		
		System.out.println(fluffy.toString());
		
		//Polymorphic instance method: toString()
		Object fluffy2 = new Animal();	//All animals are objects. Implicit upcasting.
		
		//fluffy2.setName("fluffy2"); will not work
		
		((Animal)fluffy2).setName("Fluffy2");
		//In order to access the Animal methods, we need to cast.
		//No implicit downcasting
		//But when we call fluffy2.toString(), we get the Animal version.
		System.out.println(fluffy2.toString());
		
		//At compile time, the declare type is checked.
		//Casts can work (at compile time) up and down the inheritance tree in any direction.
		Object fluffy3 = new Object();
		//((Animal)fluffy3).setName("Fluffy3");
		//This throws a ClassCastException
		//At runtime, the actual type is checked. At compile time, the compiler checks the declared type.
		
		Cat c1 = new Cat(8, "Paul");
		Cat c2 = new Cat(7, "Peter");
		Dog d1 = new Dog();
		Dog d2 = new Dog();
		
		/*
		 * Arrays:
		 * Elements must be the same type, and length must be specified at creation time.
		 * Length of an array is immutable. Block of continuous memory is allocated.
		 * java.util.Arrays; (note the s) for useful methods.
		 * All elements set to the default value for that data type.
		 * 
		 */
		
		Animal[] animalArray = new Animal[3];
		animalArray[0] = c1;
		animalArray[1] = c2;
		animalArray[2] = d1;
		
		
		for(int i = 0; i < animalArray.length; i++) {
			animalArray[i].makeNoise();
		}
		
		System.out.println(Cat.catLatinName);	//Best practice is to use the class name to 
											//access static members.
		
		//This will change the static field for all instances of Dog.
		//d2.dogLatinName = "doggus doggus";
		
		System.out.println(d1.latinName);
		System.out.println(d2.latinName);
		
		
		//Fun with shadowing
		d2.setName("Fido");
		System.out.println(d2.getName());
		
		Animal a = new Dog();
		System.out.println((Dog)a).latinName);	//Casting will cause Dog's latinName to be returned.
												//Not casting (Dog) will cause Animal's latinName to be returned.
	}
	
}
