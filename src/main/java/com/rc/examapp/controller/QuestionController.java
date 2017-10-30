package com.rc.examapp.controller;

import com.rc.examapp.model.Exam;
import com.rc.examapp.model.Question;
import com.rc.examapp.service.ExamService;
import com.rc.examapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by R.E.M. Claassen on 27-10-2017.
 */

@RestController
public class QuestionController {

	@Autowired
	public QuestionService questionService;

		@RequestMapping("/questions")
		public List<Question> getQuestions() {
			return questionService.getAll();
		}

	@RequestMapping("/questions/{questionId}")
	public Question getQuestion(@PathVariable("questionId") long questionId) {
		return questionService.getById(questionId);
	}

}
