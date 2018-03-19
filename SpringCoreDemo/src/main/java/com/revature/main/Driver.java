package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.AutoBearByName;
import com.revature.beans.AutoBearByType;
import com.revature.beans.Bear;
import com.revature.beans.BearWithAuto;
import com.revature.beans.BearWithConstructor;
import com.revature.beans.BearWithSetter;
import com.revature.beans.Cave;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		// funWithCaves(ac);

		funWithBears(ac);

		// close AC after you're done with it
		((AbstractApplicationContext) ac).close();
	}

	static void funWithBears(ApplicationContext ac) {
		Bear b1 = (BearWithSetter) ac.getBean("bearWithSetter");
		b1.methodInBear();
		Bear b2 = (BearWithConstructor) ac.getBean("bearWithConstructor");
		b2.methodInBear();
		Bear b3 = (AutoBearByName) ac.getBean("autoBearByName");
		b3.methodInBear();
		Bear b4 = (AutoBearByType) ac.getBean("autoBearByType");
		b4.methodInBear();
		Bear b5 = (BearWithAuto) ac.getBean("bearWithAuto");
		b5.methodInBear();
	}

	static void funWithCaves(ApplicationContext ac) {
		Cave c = (Cave) ac.getBean("cave");

		System.out.println(c.toString());

		Cave c1 = (Cave) ac.getBean("cave");

		System.out.println(c1.toString()); // same cave! singleton scoped by
											// default

		System.out.println("cave id: " + c.getId());
		System.out.println("cave name: " + c.getName());
	}

}
