package com.rc.examapp.exam;

import com.rc.examapp.core.BaseEntity;
import com.rc.examapp.question.Answer;
import com.rc.examapp.question.Question;
import com.rc.examapp.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Exam class contains all basic info about an Exam, including a list of questions
 * {@link Question} and {@link Answer} are created as separate classes
 *
 * @author RC
 * @version 1.0
 */

@Entity
public class Exam extends BaseEntity{

	private String title;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User owner;
	private LocalDateTime createdOn;
	private int passingPercentage;

	@ManyToMany(cascade = {CascadeType.PERSIST})
	@JoinTable(
			name = "exam_question",
			joinColumns = {@JoinColumn(name = "exam_id")},
			inverseJoinColumns = {@JoinColumn(name = "question_id")}
	)
	private List<Question> questions; //TODO Q: Set or List for unique exams?

	public Exam() {
		super();
		this.questions = new ArrayList<>();
		this.createdOn = LocalDateTime.now();
	}

	public Exam(String title, User owner, int passingPercentage) {
		this();
		this.title = title;
		this.owner = owner;
		this.passingPercentage = passingPercentage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public int getPassingPercentage() {
		return passingPercentage;
	}

	public void setPassingPercentage(int passingPercentage) {
		this.passingPercentage = passingPercentage;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void addQuestion(Question question) {
		this.questions.add(question);
		//question.addExam(this); // Exam already is owning side of relation
	}

	public void removeQuestion(Question question){
		this.questions.remove(question);
	}
}
