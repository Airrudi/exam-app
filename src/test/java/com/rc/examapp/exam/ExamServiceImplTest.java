package com.rc.examapp.exam;

import com.rc.examapp.question.Answer;
import com.rc.examapp.question.AnsweredQuestion;
import com.rc.examapp.question.Question;
import com.rc.examapp.user.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by R.E.M. Claassen on 2-11-2017.
 */
public class ExamServiceImplTest {

	@Autowired
	ExamService examService = new ExamServiceImpl();

	Exam exam;
	UserExam userExam1;
	UserExam userExam2;

	@Before
	public void setup(){
		User user = new User("Piet", "piet@email.nl");

		Question question1 = new Question("Hoe hoog is de Eiffeltoren", Question.QuestionType.MULTIPLE);
		Answer answer1a = new Answer("100", false);
		Answer answer1b = new Answer("400", false);
		Answer answer1c = new Answer("300", true);
		Answer answer1d = new Answer("200", false);
		question1.addAnswer(answer1a);
		question1.addAnswer(answer1b);
		question1.addAnswer(answer1c);
		question1.addAnswer(answer1d);

		Question question2 = new Question("Wie is de mol?", Question.QuestionType.MULTIPLE);
		Answer answer2a = new Answer("Jan", false, 0);
		Answer answer2b = new Answer("Karel", true, 20);
		Answer answer2c = new Answer("Piet", false, 0);
		Answer answer2d = new Answer("Geert", 0);
		question2.addAnswer(answer2a);
		question2.addAnswer(answer2b);
		question2.addAnswer(answer2c);
		question2.addAnswer(answer2d);

		exam = new Exam("TestExam", user, 60);
		exam.addQuestion(question1);
		exam.addQuestion(question2);

		userExam1 = new UserExam(user, exam);
		AnsweredQuestion answeredQuestion1 = new AnsweredQuestion(question1, answer1b);
		AnsweredQuestion answeredQuestion2 = new AnsweredQuestion(question2, answer2b);

		userExam1.addAnsweredQuestion(answeredQuestion1);
		userExam1.addAnsweredQuestion(answeredQuestion2);

		userExam2 = new UserExam(user, exam);
		userExam2.addAnsweredQuestion(answeredQuestion1);
	}

	@Test
	public void calculatedMaximumExamScoreIsCorrect() throws Exception {
		int score = examService.calculateScore(exam);

		assertEquals(21, score);
	}

	@Test
	public void calculatedMaximumUserExamScoreIsCorrect() throws Exception {
		int score = examService.calculateScore(userExam1);

		assertEquals(20, score);
	}

	@Test
	public void calculateGradeIsCorrect() throws Exception {
		Double grade = examService.calculateGrade(userExam1);
		assertEquals(new Double(9.5), grade); // TODO: double deprecated, is this the correct alternative?
	}

	@Test
	public void completedExamsAreCorrectlyJudged() throws Exception {
		assertEquals(true, examService.isExamCompleted(userExam1));
		assertEquals(false, examService.isExamCompleted(userExam2));
	}


}