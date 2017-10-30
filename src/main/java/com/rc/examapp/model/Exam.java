package com.rc.examapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by R.E.M. Claassen on 27-10-2017.
 */

@Entity
public class Exam {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	private String title;
	private String owner;
	private LocalDateTime createdOn;
	private int passingPercentage;

	@ManyToMany
	@JoinTable(
			name="exam_question",
			joinColumns={@JoinColumn(name="exam_id")},
			inverseJoinColumns={@JoinColumn(name="question_id")}
	)
	private Set<Question> questions; //TODO Q: Set or List for unique exams?

	public Exam() {}

	public Exam(String title, String owner, int passingPercentage) {
		this.title = title;
		this.owner = owner;
		this.passingPercentage = passingPercentage;
		this.createdOn = LocalDateTime.now();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
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

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
}
