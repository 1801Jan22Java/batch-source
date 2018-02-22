package com.revature.dao;
import java.util.List;
import org.hibernate.Session;
import com.revature.beans.*;

import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao {
	@Override
	

    public List<CatLover> getUsers() {

        Session s = HibernateUtil.getSession();

        List<CatLover> users = s.createQuery("from User").list();

        //s.commit();

        s.close();

        return users;

    }
	
	@Override

    public CatLover getUserById(int id) {

        Session s = HibernateUtil.getSession();

        CatLover user = (CatLover) s.get(CatLover.class, id);

        return user;

    }
    
    @Override

    public int addUser(CatLover u) {

        return (int) HibernateUtil.getSession().save(u);

    }    @Override

    public void merge(CatLover u) {

        HibernateUtil.getSession().merge(u);

    }
    
    @Override

    public void deleteUser(CatLover u) {

        HibernateUtil.getSession().delete(u);

    }

	@Override
	public void saveOrUpdate(CatLover f) {
		HibernateUtil.getSession().saveOrUpdate(f);
	}

    

}