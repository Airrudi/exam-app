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
 * Inspired by TeamTreeHouse's tutorial about creating a REST API using Spring
 * Used for creating initial data when building up the application
 *
 * @author RC
 * @version 1.0
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
//		Exam exam = new Exam("Proefexamen", "Piet", 60);
//		exam.addQuestion(new Question("What is your name", Question.QuestionType.OPEN));
//		examRepository.save(exam);
	}
}
