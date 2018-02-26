package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.domains.Animal;
import com.revature.util.HibernateUtil;

public class AnimalDaoImpl implements AnimalDao{
	@Override
	public List<Animal> getAll() {
		Session s = HibernateUtil.getSession();
		List<Animal> animals = s.createQuery("from Animal").list();
		s.close();
		return animals;
	}

	@Override
	public Animal getById(int id) {
		Session s = HibernateUtil.getSession();
		Animal animal = (Animal) s.get(Animal.class, id);
		return animal;
	}

	@Override
	public int add(Animal animal) {
		return (int) HibernateUtil.getSession().save(animal);
	}

	@Override
	public void delete(Animal animal) {
		HibernateUtil.getSession().delete(animal);
	}

	@Override
	public void merge(Animal animal) {
		HibernateUtil.getSession().merge(animal);
	}

	@Override
	public void saveOrUpdate(Animal animal) {
		HibernateUtil.getSession().saveOrUpdate(animal);
	}
}
