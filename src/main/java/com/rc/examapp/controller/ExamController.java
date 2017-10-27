package com.rc.examapp.controller;

import com.rc.examapp.model.Exam;
import com.rc.examapp.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by R.E.M. Claassen on 27-10-2017.
 */

@RestController
public class ExamController {

	@Autowired
	public ExamService examService;

	@RequestMapping("/exams/")
	public List<Exam> getExams() {

		return examService.getAll();
	}

	@RequestMapping("/exams/{examId}")
	public Exam getExam(@PathVariable("examId") long examId){

		return examService.getById(examId);
	}


}
