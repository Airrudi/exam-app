package com.rc.examapp.question;

import com.rc.examapp.core.BaseEntity;
import com.rc.examapp.exam.Exam;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Question class contains the text and a list of possible answers in case of multiple choice questions
 * A question can be used in different {@link Exam exams}
 *
 * @author R.E.M. Claassen
 * @version 1.0
 */
@Entity
public class Question extends BaseEntity {

	/**
	 * The QuestionType says something about the type of question, currently we have (open) questions and multiple choice.
	 * Since it only exists for a question, the enum is created inside the Question class
	 */
	public enum QuestionType{
		MULTIPLE, OPEN;
	}

	private String text;

	@Enumerated(EnumType.STRING)
	@Column(name = "questionType") //TODO: What would have been the default name?
	private QuestionType type;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private List<Answer> answers;

	@ManyToMany
	private List<Exam> exams;

	//TODO: Do you want to know to which exams each question belongs? How to incorporate without creating endless loop?

	protected Question() {
		super();
		this.answers = new ArrayList<>();
		this.exams = new ArrayList<>();
	}

	public Question(String text, QuestionType type) {
		this();
		this.text = text;
		this.type = type;
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void addAnswer(Answer answer){
		answer.setQuestion(this);
		this.answers.add(answer);
	};

	public List<Exam> getExams() {
		return exams;
	}

	public void addExam(Exam exam) {
		this.exams.add(exam);
	}
}
