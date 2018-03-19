package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {


	private static SessionFactory mySessionFactory;
	
	private static SessionFactory getSessionFactory(String filename) {
		// If no session exists make new one before returning it
		// org.hibernate loads jdbc into memory using reflection and maven's mapped dependency
		if (HibernateUtil.mySessionFactory == null) {
			Configuration c = new Configuration().configure(filename);
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
			HibernateUtil.mySessionFactory = c.buildSessionFactory(sr);
		}
		return HibernateUtil.mySessionFactory;
	}
	
	public static Session getSession() {
		return getSessionFactory("hibernate.cfg.xml").openSession();
	}

}
