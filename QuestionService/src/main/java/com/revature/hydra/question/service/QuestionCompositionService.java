package com.revature.hydra.question.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Bucket;
import com.revature.beans.Question;
import com.revature.hydra.question.data.BucketRepository;
import com.revature.hydra.question.data.QuestionRepository;
import com.revature.util.HibernateUtil;

@Service
public class QuestionCompositionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private BucketRepository bucketRepository;
	
	public void createNewQuestion(Integer bucketId, String questionText, String[] possibleAnswers, Integer[] tagIDs) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Bucket b = (Bucket) s.createQuery("from Bucket").
		Question question = new Question();
	}
	
}
