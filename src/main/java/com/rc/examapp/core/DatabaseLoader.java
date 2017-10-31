package com.rc.examapp.core;

import com.rc.examapp.exam.Exam;
import com.rc.examapp.exam.ExamRepository;
import com.rc.examapp.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.management.Query;

/**
 * Created by R.E.M. Claassen on 31-10-2017.
 */
@Component
public class DatabaseLoader implements ApplicationRunner {

	private final ExamRepository examRepository;

	@Autowired
	public DatabaseLoader(ExamRepository examRepository) {
		this.examRepository = examRepository;
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		Exam exam = new Exam("Proefexamen", "Piet", 60);
		exam.addQuestion(new Question("What is your name", Question.QuestionType.OPEN));
		examRepository.save(exam);
	}
}
