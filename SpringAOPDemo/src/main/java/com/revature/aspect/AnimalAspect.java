package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.service.AnimalService;
import com.revature.service.PersonService;

@Aspect
@Component
public class AnimalAspect {
	
	@Autowired
	PersonService personService;
	
	// execution(<any bean in any package> wake<anything after>(<any args>))
	@AfterReturning(pointcut="execution(* wake*(..))")
	public void afterWakeAnimal(JoinPoint jp) {
		System.out.println("That wasn't a good choice");
	}
	
	// can it actually catch you?
	@Around("execution(* *CatchesYou(..))")
	public void afterCatchesYou(ProceedingJoinPoint pjp) throws Throwable {
		
		int personSpeed = PersonService.getSpeed();
		AnimalService as = (AnimalService) pjp.getTarget();
		// returns the object that had the called method under advice
		// method is watching execution of the method, processing the info
		// if you are faster than the animal, won't actually execute the method 
		if(personSpeed <= as.getSpeed()) {
			System.out.println("Too slow!");
			pjp.proceed();
			if(!as.getFull()) {
				as.setFull(true);
				System.out.println("You became lunch");
			} else {
				System.out.println("You got lucky");
			}
		} else {
			System.out.println("You got away!");
		}
	}
	
	
	
}
