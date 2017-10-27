package com.rc.examapp.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by R.E.M. Claassen on 27-10-2017.
 */
public class Exam {

	private long id;
	private String title;
	private String owner;
	private LocalDateTime createdOn;
	private int passingPercentage;

	private List<Question> questions; //TODO Q: Why not use Set for unique exams?

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
}
