package com.revature.caliber;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.caliber.model.SimpleBucket;
import com.revature.caliber.repository.BucketRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BucketDAOTest {

	public static final Logger log = Logger.getLogger(BucketDAOTest.class);
	
	@Autowired
	BucketRepository dao;
	
	SimpleBucket simpleBucket;
	
	@Before
	public void initialize() {
		log.info("initializing a test Bucket for use in Buckets");
		simpleBucket  = new SimpleBucket();
		simpleBucket.setBucketCategory("OOP");
		simpleBucket.setBucketDescription("pretty important");
		simpleBucket.setIsActive(true);
	}
	
	@Test
	public void testFindAll() {
		log.info("Getting All Buckets");
		List<SimpleBucket> buckets = dao.findAll();
		
		assertFalse(buckets.isEmpty());
	}
	
	@Test
	public void addBucket() {
		log.info("Adding Bucket");
		SimpleBucket savedBucket = dao.save(simpleBucket);
		assertEquals(simpleBucket.getBucketCategory(), savedBucket.getBucketCategory());
	}
	
	
}
