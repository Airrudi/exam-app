package com.rc.examapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by R.E.M. Claassen on 27-10-2017.
 */

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	private String text;
	private boolean correct;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;

	public Answer() {}

	public Answer(String text, boolean correct) {
		this.text = text;
		this.correct = correct;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
