package com.revature.oop;

public class FunWithOop {
	
<<<<<<< HEAD
	public static void main(String[] args) {
		//Create a new Animal
		Animal fluffy = new Animal();
		
		System.out.println(fluffy.toString());
		
		//polymorphic instance method: toString
		Object fluffy2 = new Animal(); // implicit upcasting, Animal -> Object
		
		// at compile time, compiler doesn't know that it's an Animal
		//fluffy2.setName("Fluffy2") <-- not possible
		
		// Instead, we cast it to an Animal type
		// In order to access the Animal methods, we need to cast
		// There is no implicit downcasting
		// Object -> Animal
		((Animal)fluffy2).setName("fluffy2");
		
		//but! when we call fluffy2.toString, we get the Animal version
		System.out.println(fluffy2.toString());
		
		// at compile time, the declared type is checked.
		// casts can work (at compile time), up or down the 
		// 	inheritance tree
		Object fluffy3 = new Object();
		//((Animal)fluffy3).setName("fluffy3");
		// this does not work at runtime, even though it compiles nice.
		// this throws a ClassCastException.
		// at runtime, the actual type is checked
		
		Cat c1 = new Cat(8, "Paul");
		Cat c2 = new Cat(7, "Peter");
=======
	public static void main(String[] args){
		
		
		//create a new Animal
		Animal fluffy = new Animal();
		System.out.println(fluffy.toString());
		
		//polymorphic instance method: toString
		Object fluffy2 = new Animal(); //implicit upcasting
		((Animal) fluffy2).setName("fluffy2"); 
		//in order to access the Animal methods, we need to cast
		//no implicit downcasting
		//but! when we call fluffy2.toString, we get the Animal version
		System.out.println(fluffy2.toString());
		
		//at compile time, the declared type is checked. 
		//casts can work (at compile time) up or down the inheritance tree
		Object fluffy3 = new Object();
		//((Animal) fluffy3).setName("fluffy3");
		//this throws a ClassCastException
		//at runtime, the actual type is checked. 
		
		Cat c1 = new Cat(8,"Paul");
		Cat c2 = new Cat(7,"Peter");
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
		Dog d1 = new Dog();
		
		/*
		 * Arrays:
		 * Elements must be the same type, length must be specified
		 * length is immutable (contiguous block of memory is allocated)
		 * java.util.Arrays (note the s) for useful methods
<<<<<<< HEAD
		 * all the elements set to default for that data type
=======
		 * all elements are set to default value for that data type 
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
		 */
		Animal[] animalArray = new Animal[3];
		animalArray[0] = c1;
		animalArray[1] = c2;
		animalArray[2] = d1;
		
<<<<<<< HEAD
		for(int i=0; i<animalArray.length; i++) {
			animalArray[i].makeNoise();
		}
		
		//Accessing static properties
		//Best practice: get it from the class directly and not from instances
=======
		for (int i = 0; i<animalArray.length; i++){
			animalArray[i].makeNoise();
		}
		
		//best practices: refer to static members via the class
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
		System.out.println(Cat.catinName);
		
		Dog d2 = new Dog();
		
<<<<<<< HEAD
		// This will change the static field for all instances of Dog
		Dog.latinName="doggus doggus";
		
		//IDE is warning that we shouldn't access via instance
		System.out.println(d1.latinName);
		System.out.println(d2.latinName);
		
		// We gave Animal a latinName to see what would happen. 
		// It prints out Animalis
		System.out.println(Animal.latinName);
		
		// We now created an animal object of type Dog
		Animal dog = new Dog();
		
		// If we cast it to type Dog, it prints out the Dog's variable
		// Therefore, the Dog shadows the Animal
		System.out.println(((Dog)dog).latinName);
		
		// Without casting, it prints out the Animal's latinName
		// Shadowing does not happen here
		// Because this is still of type Animal(?) or still using scope of
		// Animal
		System.out.println(dog.latinName);
		dog.makeNoise();
	}
	
=======
		//this will change the static field for ALL INSTANCES OF DOG
		d2.latinName = "doggus doggus";
		
		System.out.println(d1.latinName);
		System.out.println(d2.latinName);
		
		//fun with shadowing
		d2.setName("fido");
		System.out.println(d2.getName());
		
		Animal a = new Dog();
		System.out.println(((Dog) a).latinName);
		
	}

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
}
