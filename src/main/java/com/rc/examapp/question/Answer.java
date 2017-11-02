package com.rc.examapp.question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rc.examapp.core.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by RC on 27-10-2017.
 */

@Entity
public class Answer extends BaseEntity{

	// TODO: Assumption: A correct answer has a minimum score of 1, an incorrect answer has the score of 0

	private String text;
	private int score;
	private boolean isCorrect;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "question_id")
	@JsonIgnore
	private Question question;

	protected Answer() {
		super();
	}

	public Answer(String text){
		this();
		this.text = text;
	}

	public Answer(String text, boolean isCorrect, int score) {
		this(text);
		this.isCorrect = isCorrect;
		this.score = score;
	}

	public Answer(String text, boolean isCorrect) {
		this(text, isCorrect, isCorrect ? 1 : 0);
	}

	public Answer(String text, int score) {
		this(text, score > 0 ? true : false, score);
	}



	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return "Answer is: " + text;
	}
}
