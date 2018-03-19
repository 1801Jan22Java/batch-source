package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BearWithAuto extends Bear {
	
	@Autowired //@Inject is pretty much synonymous
	private Cave cave;
	
	@Override
	public Cave getCave(){
		return this.cave;
	}
	
	@Override
	public void methodInBear(){
		System.out.println("method in BearWithAutomagic. this bear is: "+this.toString());
		System.out.println("cave: "+cave.getName());
	}
}
