package com.revature.hydra.question.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Trainee;
import com.revature.hydra.question.service.QuestionService;

@RestController
@CrossOrigin
public class QuestionController {
	
	private static final Logger log = Logger.getLogger(QuestionController.class);
	private QuestionService questionService;
	
	@Autowired
	public void setTrainingService(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@RequestMapping(value = "/question/createQuestion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createNewQuestion(@RequestParam(required = true) Integer bucketId, @RequestParam(required = true) String questionText, @RequestParam(required = true) String[] possibleAnswers, @RequestParam(required = true) Integer[] tagIDs) {
		log.info("Creating new question for bucket: " + bucketId);
		questionService.createNewQuestion(bucketId, questionText, possibleAnswers, tagIDs);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
