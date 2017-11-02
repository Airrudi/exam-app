package com.rc.examapp.exam;

import com.rc.examapp.core.BaseEntity;
import com.rc.examapp.question.AnsweredQuestion;
import com.rc.examapp.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by R.E.M. Claassen on 2-11-2017.
 */
@Entity
public class UserExam extends BaseEntity {

	// TODO Q: Use OneToOne annotation?
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// TODO Q: Use OneToOne annotation?
	@OneToOne
	@JoinColumn(name = "exam_id")
	private Exam exam;

	@OneToMany(mappedBy = "userExam")
	private List<AnsweredQuestion> answeredQuestions;

	private LocalDateTime startedOn;
	private LocalDateTime lastModifiedOn;
	private LocalDateTime completedOn;

	public UserExam() {
		super();
		this.answeredQuestions = new ArrayList<>();
		this.startedOn = LocalDateTime.now();
	}

	public UserExam(User user, Exam exam) {
		this();
		this.user = user;
		this.exam = exam;
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

	public List<AnsweredQuestion> getAnsweredQuestions() {
		return answeredQuestions;
	}

	public void addAnsweredQuestion(AnsweredQuestion answeredQuestion) {
		this.answeredQuestions.add(answeredQuestion);
	}

	public LocalDateTime getStartedOn() {
		return startedOn;
	}

	public void setStartedOn(LocalDateTime startedOn) {
		this.startedOn = startedOn;
	}

	public LocalDateTime getEndDate() {
		return lastModifiedOn;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.lastModifiedOn = endDate;
	}

	public LocalDateTime getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(LocalDateTime completedOn) {
		this.completedOn = completedOn;
	}
}
