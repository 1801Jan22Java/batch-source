package com.revature.dao;import java.util.List;import org.hibernate.Session;import com.revature.beans.Shelter;

import com.revature.util.HibernateUtil;public class ShelterDaoImpl implements ShelterDao{    @Override

    public List<Shelter> getShelters() {

        Session s = HibernateUtil.getSession();

        List<Shelter> shelters = s.createQuery("from Shelter").list();

        //s.commit();

        s.close();

        return shelters;

    }    @Override

    public Shelter getShelterById(int id) {

        Session s = HibernateUtil.getSession();

        Shelter shelter = (Shelter) s.get(Shelter.class, id);

        return shelter;

    }    @Override

    public int addShelter(Shelter f) {

        return (int) HibernateUtil.getSession().save(f);

    }    @Override

    public void merge(Shelter f) {

        HibernateUtil.getSession().merge(f);

    }    public void saveOrUpdate(Shelter f){

        HibernateUtil.getSession().saveOrUpdate(f);

    }    @Override

    public void deleteShelter(Shelter f) {

        HibernateUtil.getSession().delete(f);

    }}