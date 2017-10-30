package com.rc.examapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by R.E.M. Claassen on 27-10-2017.
 */
@Entity
public class Question {

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

	@ManyToMany(mappedBy = "questions") // TODO: How does this work? Exam must be the owner, mapped by correct?
	Set<Exam> exams; // TODO: Or use a list?

	@OneToMany
	Set<Answer> answers;

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

	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}
}
