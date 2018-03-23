package com.revature.caliber;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.caliber.model.SimpleBucket;
import com.revature.caliber.repository.BucketRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BucketRepositoryTests {

	@Autowired
	BucketRepository test;
	
	@Test
	public void TestfindOneByBucketId() {
		SimpleBucket bucket = test.findOne(5);
		bucket = test.findByBucketId((Integer)bucket.getBucketId());
		assertNotNull(bucket.getBucketId());
	}
	
}
