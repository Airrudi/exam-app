package com.rc.examapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Question class contains the text and a list of possible answers in case of multiple choice questions
 * A question can be used in different {@link Exam exams}
 *
 * @author R.E.M. Claassen
 * @version 1.0
 */
@Entity
public class Question {

	/**
	 * The QuestionType says something about the type of question, currently we have (open) questions and multiple choice.
	 * Since it only exists for a question, the enum is created inside the Question class
	 */
	public enum QuestionType{
		MULTIPLE, OPEN;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	private String text;

	@Enumerated(EnumType.STRING)
	@Column(name = "questionType") //TODO: What would have been the default name?
	private QuestionType type;

	@OneToMany
	@JoinColumn(name = "question_id")
	Set<Answer> answers;

	//TODO: Do you want to know to which exams each question belongs? How to incorporate without creating endless loop?


	public Question() {}

	public Question(String text, QuestionType type) {
		this.text = text;
		this.type = type;
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

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
}
