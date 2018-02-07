package com.revature.oop;

public class FunWithOop {
	
	public static void main(String[] args) {
		
		//create a new Animal
		Animal fluffy = new Animal();
		
		System.out.println(fluffy.toString());
		
		//polymorphic instance method: toString
		Object fluffy2 = new Animal(); //implicit upcasting
		((Animal) fluffy2).setName("fluffy2");
		//in order to access the Animal methods, we need to cast
		//no implicit downcasting
		
		//When we call fluffy2.toString(), we get the Animal version.
		//This is because Object has a toString method to run
		//However, without casting, fluffy2 can not use getName or setName
		//fluffy2.setName("fluffy3"); does not work
		System.out.println(fluffy2.toString());
		
		//at compile time, the declared type is checked.
		//casts can work (at compile time) up or down the inheritance tree
		Object fluffy3 = new Object();
		
		//throws a ClassCastException
		//at runtime, the actual type is checked and it is still Object from new Object();
		//((Animal) fluffy3).setName("fluffy3");
		
		Cat c1 = new Cat(8, "Garfield");
		Cat c2 = new Cat(7, "Peter");
		Dog d1 = new Dog();
		
		/*
		 * Arrays:
		 * Elements must be the same type, length must be specified
		 * length is immutable (contiguous block of memory is allocated)
		 * java.ultil.Arrays (note the s) for useful methods
		 * all elements are set to default value for that data type
		 */
		
		Animal[] animalArray = new Animal[3];
		animalArray[0] = c1;
		animalArray[1] = c2;
		animalArray[2] = d1;
		
		for(int i = 0; i<animalArray.length; i++) {
			animalArray[i].makeNoise();
		}
		
		//BEST PRACTICES: reer to static members via the class
		System.out.println(Cat.catinName);
		
		Dog d2 = new Dog();
		
		//this will change the static field for ALL INSTANCES OF DOG if there is NO final keyword
		d2.latinName = "Doggus doggus";
		System.out.println(d1.latinName);
		System.out.println(d2.latinName);
	}

}
