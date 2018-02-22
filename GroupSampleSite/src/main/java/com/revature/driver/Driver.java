package com.revature.driver;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.*;
import com.revature.dao.CatDaoImpl;
import com.revature.dao.ShelterDao;
import com.revature.dao.ShelterDaoImpl;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {

		
		System.out.println("Hello");
		insertUser();
		int shelterID = insertShelter();
		insertCat(shelterID);
		
		CatDaoImpl cdi = new CatDaoImpl();
		List<Cat> cats = cdi.getCatByShelterId(1);
		
		for(Cat c : cats) {
			System.out.println(c);
		}
		
		//getCatsByUserID(int userID);
		
		//getCatsByShelterID(int shelterID);
		
		
	}
	
	static void insertUser() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		CatLover guy = new CatLover("Mickey Mouse", "MickeyMouse@magic.com", "disneyMagic");
		
		s.save(guy);
		
		tx.commit();
		s.close();
	}
	
	static int insertShelter() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		Shelter sh = new Shelter("Animal Shelter");
		
		int gen = (int)s.save(sh);
		
		tx.commit();
		s.close();
		
		return gen;
	}

	static int insertCat(int shelterID) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		ShelterDao sd = new ShelterDaoImpl();
		
		Shelter sh = sd.getShelterById(shelterID);
		
		Cat cat = new Cat("jimmy", "jaxsb", sh);
		
		int catID = (int)s.save(cat);
		
		tx.commit();
		s.close();
		
		return catID;
		
	}
}
