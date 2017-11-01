package com.rc.examapp.exam;

import com.rc.examapp.question.Question;
import com.rc.examapp.question.QuestionRepository;
import com.rc.examapp.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author RC
 * @version 1.0
 */

@RestController
@RequestMapping("/exams/")
public class ExamController {

	@Autowired
	ExamService examService;

	@Autowired
	QuestionService questionService;

	@RequestMapping(value = "{examId}/questions", method = RequestMethod.GET)
	public ResponseEntity<List<Question>> showExamQuestions(@PathVariable("examId") Long examId) {
		Exam exam = examService.findOne(examId);

		return ResponseEntity.ok(exam.getQuestions());
	}

	/**
	 * Add a question to a exam
	 * */
	@RequestMapping(value = "{examId}/questions", method = RequestMethod.PUT)
	public ResponseEntity<Exam> addQuestionToExam(@PathVariable("examId") Long examId, @RequestBody Question question) {

		Question savedQuestion = questionService.save(question);
		Exam exam = examService.findOne(examId);
		exam.addQuestion(savedQuestion);
		examService.save(exam);

		return ResponseEntity.ok(exam);
	}
}
