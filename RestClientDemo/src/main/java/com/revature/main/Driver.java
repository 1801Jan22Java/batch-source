package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.TRex;
import com.revature.client.TRexClient;

public class Driver {
	
	public static void main(String[] args){
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		TRexClient tc = ac.getBean("tRexClient", TRexClient.class);
		tc.setResourceUrl("http://localhost:8085");
		
		//System.out.println(tc.getTRexes());
		
		TRex t = (TRex) ac.getBean("tRex");
		t.setName("Elrond");
		t.setFeatherColor("green");
		
		tc.saveTRex(t);
				
	}

}
