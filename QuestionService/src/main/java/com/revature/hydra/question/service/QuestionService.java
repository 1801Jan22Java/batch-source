package com.revature.hydra.question.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	
	private static final Logger log = Logger.getLogger(QuestionService.class);
	
	@Autowired
	private QuestionCompositionService questionDAO;
	
	
	
}
