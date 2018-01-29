package com.revature.oop;

public class FunWithOop 
{
	public static void main(String[] args)
	{
		//create a new animal
		Animal fluffy = new Animal();
		
		//printed fully qualified name and the memory location when the method is not over ridden
		//Once the toString is overridden, we have a more specific method being called
		//System.out.println(fluffy.toString());
		
		//polymorohic instance method: toString
		/*
		 * this works because animal is a subclass of object
		 * this can't use the toString method we overrode because the object has been declared an object type
		 */
		Object fluffy2 = new Animal();
		/*
		 * In order to access the animal specific methods, we have to cast up
		 * We have no implicit down casting, only up casting
		 * but! when we call fluffy2.toString er get the Animal version
		 */
		
		//implicit upcasting
		((Animal) fluffy2).setName("fluffy2");
		//System.out.println(fluffy2.toString());
		
		//at compile time, the declared type is checked.
		//casts can work (st compile time) up or down the inheritance tree
		//Object fluffy3 = new Object();
		//((Animal)fluffy3).setName("fluffy3");
		//this doesn't work because fluffy3 is not an animal based on declaration
		//This throws a class cast exception 
		//at runtime, the actual type is checked
		
		Cat c1 = new Cat(8,"Paul");
		Cat c2 = new Cat(7, "Peter");
		//This works because Animal has a no args constructor
		Dog d1 = new Dog();
		/*
		 * Arrays:
		 * Elements must be the same type, length must be specified
		 * length is immutable (contiguous block of memeory allocated)
		 * java.util.Arrays (note the s) for usual methods
		 * all elements are set to default values for that data type
		 */
		Animal[] animalArray = new Animal[3];
		animalArray[0] = c1;
		animalArray[1] = c2;
		animalArray[2] = d1;
		for(int i =0; i < 3; i++)
		{
			//System.out.println(animalArray[i].toString());
			animalArray[i].makeNoise();
		}
		//Best practices: you can use an instance varialbe to get the latin name, but you should not.
		//you should always use the class to refer to static variables 
		System.out.println(Cat.catinName);
		Dog d2 = new Dog();
		//this will change the static field of all instances of Dog
		d2.latinName = "doggus doggus";
		//fun with shodowing
		System.out.println(c1.x);
	}
	
	
}
