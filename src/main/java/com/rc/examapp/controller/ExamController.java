package com.rc.examapp.controller;

import com.rc.examapp.dao.ExamDao;
import com.rc.examapp.model.Exam;
import com.rc.examapp.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


	@RequestMapping(value = "/exams/", method = RequestMethod.GET)
	public List<Exam> getExams() {
		
		return examService.getAll();
	}

	@RequestMapping(value = "/exams/{examId}", method = RequestMethod.GET)
	public Exam getExam(@PathVariable("examId") long examId){

		return examService.getById(examId);
	}

	@RequestMapping(value = "/exams/", method = RequestMethod.POST)
	public Exam createExam(@RequestBody Exam exam){ // @RequestBody, @ResponseBody etc....

		return examService.save(exam);
	}

	@RequestMapping(value = "/exams/{examId}", method = RequestMethod.PUT)
	public Exam updateExam(@RequestBody Exam exam, @PathVariable("examId") long examId){ // @RequestBody, @ResponseBody etc....

		Exam oldExam = examService.getById(examId);

		// TODO: There is an easier way to just persist the exam object so that changes will automatically be made?
		if (exam.getOwner() != null) {
			oldExam.setOwner(exam.getOwner());
		}

		// TODO: Exams with 0 percentage should be possible
		if (exam.getPassingPercentage() != 0) {
			oldExam.setPassingPercentage(exam.getPassingPercentage());
		}

		oldExam.setPassingPercentage(exam.getPassingPercentage());
		oldExam.setTitle(exam.getTitle());
//		exam.setId(examId);
//		System.out.println(exam);

		// TODO Q: Save directly to dao, or always user service layer?
		return examService.save(oldExam);


	}



}
