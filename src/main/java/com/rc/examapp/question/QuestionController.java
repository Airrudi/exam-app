package com.rc.examapp.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RC
 * @version 1.0
 */

@RestController
@RequestMapping("/questions/")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	//TODO: When adding a new answer, you just persist the entire Question
//	@RequestMapping(value = "{questionId}", method = RequestMethod.PUT)
//	public ResponseEntity<Question> showExamQuestions(@PathVariable("questionId") Long questionId, @RequestBody Answer answer) {
//		Question question = questionService.findOne(questionId);
//		question.addAnswer(answer);
//		questionService.save(question); //TODO Q: Is this required? Isn't the question already in persistence context by retrieving it?
//
//		return ResponseEntity.ok(question);
//	}
}