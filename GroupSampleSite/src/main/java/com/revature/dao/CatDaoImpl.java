package com.revature.dao;import java.util.ArrayList;
import java.util.List;import org.hibernate.Session;import com.revature.beans.Cat;

import com.revature.util.HibernateUtil;public class CatDaoImpl implements CatDao{    @Override

    public List<Cat> getCats() {

        Session s = HibernateUtil.getSession();

        List<Cat> cats = s.createQuery("from Cat").list();

        //s.commit();

        s.close();

        return cats;

    }    @Override

    public Cat getCatById(int id) {

        Session s = HibernateUtil.getSession();

        Cat cat = (Cat) s.get(Cat.class, id);

        return cat;

    }
    
    public List<Cat> getCatByShelterId(int id){

        Session s = HibernateUtil.getSession();

        List<Cat> cats = s.createQuery("from Cat").list();

        List<Cat> catsOfShelter = new ArrayList<Cat>();
        
        for(Cat c : cats) {
        	
        	if(c.getShelter().getShelterId()==id) {
        		catsOfShelter.add(c);
        	}
        }
        
        //s.commit();

        s.close();

        return catsOfShelter;
    }
    
    @Override

    public int addCat(Cat c) {

        return (int) HibernateUtil.getSession().save(c);

    }    @Override

    public void merge(Cat c) {

        HibernateUtil.getSession().merge(c);

    }    public void saveOrUpdate(Cat c){

        HibernateUtil.getSession().saveOrUpdate(c);

    }    @Override

    public void deleteCat(Cat c) {

        HibernateUtil.getSession().delete(c);

    }}