package com.revature.oop;

/*
 * This class is a non-trademarked Revature education class for learning about OOP. 
 * Represents that which is the worst in humanity, 42, Nirvana, or whatever you like.
 */
public class FunWithOop {

	public static void main(String[] args) {
		
		Animal fluffy = new Animal();
		
		System.out.println(fluffy.toString());
		
		// Polymorphic instance method: toString
		Object fluffy2 = new Animal();
		((Animal) fluffy2).setName("fluffy2");
		// In order to access the Animal methods, we need to cast
		// No implicit down-casting
		// But! when we call fluffy2.toString, we get the Animal version
		System.out.println(fluffy2.toString());
		
		// At compile time, the declared type is checked.
		// Casts can work (at compile time) up or down the inheritance tree
		Object fluffy3 = new Object();
		// ((Animal) fluffy3).setName("fluffy3"); This throws a class cast exception
		// At runtime, the actual type is checked
		System.out.println(fluffy3.toString());
		
		Cat c1 = new Cat(8, "Paul");
		Cat c2 = new Cat(7, "Peter");
		Dog d1 = new Dog();
		
		/*
		 * Arrays:
		 * Elements must be of same type, length must be specified.
		 * Length is immutable (contiguous block of memory is allocated)
		 * java.util.Arrays (note the s) for useful methods.
		 * All elements are set to default value for that data type.
		 */
		
		Animal[] animalArray = new Animal[3];
		
		animalArray[0] = c1;
		animalArray[1] = c2;
		animalArray[2] = d1;
		
		for (int i = 0; i < animalArray.length; i++) {
			animalArray[i].makeNoise();
		}
		
		// Best practices: Refer to static members via its class.
		System.out.println(Cat.catinName);
		
		Dog d2 = new Dog();
		
		// This will change the static field for all instances of Dog!!!
		d2.latinName = "doggus doggus";
		
		System.out.println(d1.latinName);
		System.out.println(d2.latinName);
		
	}

}
