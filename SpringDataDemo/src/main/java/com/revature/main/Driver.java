package com.revature.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.TRex;
import com.revature.repository.TrexDao;

public class Driver {

	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		
		//addSomeDinos(ac);
		TrexDao td = (TrexDao) ac.getBean("trexDao");
		
		td.delete(2);
		
		List<TRex> tlist = td.findTRexByFeatherColor("Platinum");
		
		System.out.println(tlist);
		
		((AbstractApplicationContext) ac).close();
	}
	
	static void addSomeDinos(ApplicationContext ac){
		TRex t1 = new TRex("Fred","Platinum");
		TRex t2 = new TRex("Hank","Platinum");
		TRex t3 = new TRex("Carol","Green");
		
		TrexDao td = (TrexDao) ac.getBean("trexDao");
		
		td.save(t1);
		td.save(t2);
		td.save(t3);

	}
	
}
