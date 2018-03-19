package com.revature.hydra.question.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Question;

@Repository("QuestionRepository")
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
}
