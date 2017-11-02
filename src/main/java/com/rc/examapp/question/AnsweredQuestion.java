package com.rc.examapp.question;

import com.rc.examapp.core.BaseEntity;
import com.rc.examapp.exam.Exam;
import com.rc.examapp.exam.UserExam;
import com.rc.examapp.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by R.E.M. Claassen on 2-11-2017.
 */
@Entity
public class AnsweredQuestion extends BaseEntity {

	@ManyToOne
	User user;

	@ManyToOne
	private Exam exam;

	@ManyToOne
	private UserExam userExam;

	@OneToOne
	private Question question;

	@OneToMany(mappedBy = "question")
	private List<Answer> givenAnswers;

	public AnsweredQuestion() {
		super();
		givenAnswers = new ArrayList<>();
	}

	public AnsweredQuestion(Question question) {
		this();
		this.question = question;
	}

	public AnsweredQuestion(Question question, Answer givenAnswer) {
		this(question);
		this.addGivenAnswer(givenAnswer);
	}

	public AnsweredQuestion(Question question, List<Answer> givenAnswers) {
		this(question);
		this.setGivenAnswers(givenAnswers);
	}



	public List<Answer> getGivenAnswers() {
		return givenAnswers;
	}

	public void setGivenAnswers(List<Answer> givenAnswers) {
		this.givenAnswers = givenAnswers;
	}

	// TODO Q RC: Commented methods below do not belong in POJO, since they have business logic, correct?
	public void addGivenAnswer(Answer givenAnswer) {
		this.givenAnswers.add(givenAnswer);
	}

	public void removeGivenAnswer(Answer answer) {
		this.givenAnswers.remove(answer);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public UserExam getUserExam() {
		return userExam;
	}

	public void setUserExam(UserExam userExam) {
		this.userExam = userExam;
	}
}
