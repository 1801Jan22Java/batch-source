package com.revature.main;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.*;

public class WalkInTheWoods {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		PersonService ps = (PersonService) ac.getBean("personService");
		BearService bs = (BearService) ac.getBean("bearService");
		
		bs.setWinter(false);
		
		try {
			bs.bearHibernates();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ps.wakeUpAnimal();
		bs.animalChasesYou();
		bs.animalCatchesYou();
		
		
	}

}
