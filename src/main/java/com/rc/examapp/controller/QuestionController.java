package com.rc.examapp.controller;

import com.rc.examapp.model.Exam;
import com.rc.examapp.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
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

//	@Autowired
//	public QuestionService questionService;
//
//		private static final String template = "Hello, %s!";
//		private final AtomicLong counter = new AtomicLong();
//
//		@RequestMapping("/exams")
//		public List<Exam> greeting(@RequestParam(value="name", defaultValue="World") String name) {
//			List<Exam> exams = new ArrayList<>();
//
//			Exam exam1 = new Exam("Wiskunde", "Henk", 60);
//			Exam exam2 = new Exam("Natuurkunde", "Piet", 70);
//			Exam exam3 = new Exam("Scheikunde", "Henk", 55);
//
//			exams.add(exam1);
//			exams.add(exam2);
//			exams.add(exam3);
//
//			return exams;
//		}

}
