package com.revature.singleton;

public class Driver {

	public static void main(String[] args) {
		System.out.println(Singleton.getInstance().getHi());
		System.out.println(Singleton.getInstance().getHi());

	}

}
