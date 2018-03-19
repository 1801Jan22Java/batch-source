package com.revature.driver;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.beans.Bucket;
import com.revature.beans.SimpleTrainee;
import com.revature.beans.ViolationType;
import com.revature.hydra.question.data.BucketRepository;
import com.revature.hydra.question.data.QuestionRepository;
import com.revature.util.HibernateUtil;

public class Driver {
	
	@Autowired
	QuestionRepository qr;
	
	public static void main(String... args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		//Bucket b = new Bucket(0, "OOPS", "Object Oriented Programming", true);
		//s.save(b);
		//b = (Bucket) s.createQuery("from Bucket").list().get(0);
		//System.out.println(b.getBucketId());
		tx.commit();
		s.close();
		new Driver().lel();
		System.exit(0);
	}
	
	void lel() {
		if (qr == null) {
			System.out.println("dunso");
		}
	}
	
}
