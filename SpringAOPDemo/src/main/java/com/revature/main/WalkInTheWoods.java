package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.BearService;
import com.revature.service.PersonService;

public class WalkInTheWoods {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		// TigerService ts = (TigerService) ac.getBean("tigerService");
		PersonService ps = (PersonService) ac.getBean("personService");
		BearService bs = (BearService) ac.getBean("bearService");
		
		
		
		bs.setIsWinter(false);
		
		try{
			bs.bearHibernates();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ts.animalChasesYou();
		// ts.animalCatchesYou();
		
		//ac.getBean("not a bean");

	}

}
