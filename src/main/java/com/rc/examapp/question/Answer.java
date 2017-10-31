package com.rc.examapp.question;

import com.rc.examapp.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by R.E.M. Claassen on 27-10-2017.
 */

@Entity
public class Answer extends BaseEntity{

	private String text;
	private boolean correct;

	@ManyToOne
	private Question question;

	protected Answer() {
		super();
	}

	public Answer(String text, boolean correct) {
		this();
		this.text = text;
		this.correct = correct;
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
