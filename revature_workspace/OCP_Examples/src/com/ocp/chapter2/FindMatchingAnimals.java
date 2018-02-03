package com.ocp.chapter2;

public class FindMatchingAnimals {
	private static void print(Animal animal, CheckTrait trait)
	{
		if(trait.test(animal)) System.out.println(animal);
	}
	public static void main(String[] args) {
		print(new Animal("fish",false,true), a -> a.canHop());
		print(new Animal("Kangaskhan",true,false),a->a.canHop());
		print(new Animal("Goldeen",false,true), a->a.canSwim());
		Animal c = new Animal("pikachu",true,false);
		Animal d = new Animal("ratatta", true,false);
	
		
		
	}

}
