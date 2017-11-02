package com.rc.examapp.user;

import com.rc.examapp.core.BaseEntity;
import com.rc.examapp.exam.Exam;
import com.rc.examapp.exam.UserExam;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RC on 27-10-2017.
 */
@Entity
public class User extends BaseEntity {

	private String name;
	private String email;
	private String url;
	private LocalDateTime joinedOn;

	@OneToMany(mappedBy = "user")
	private List<UserExam> takenExams;

	@OneToMany(mappedBy = "owner") // TODO: An exam can be created by 1 user (no co-creating in this stage of the app)
	private List<Exam> createdExams;

	public User(){
		super();
		takenExams = new ArrayList<>();
		createdExams = new ArrayList<>();
		joinedOn = LocalDateTime.now();
	}

	public User(String name, String emailAddress) {
		this.name = name;
		this.email = emailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<UserExam> getTakenExams() {
		return takenExams;
	}

	public void addTakenExams(UserExam takenExams) {
		this.takenExams.add(takenExams);
	}

	public LocalDateTime getJoinedOn() {
		return joinedOn;
	}

	public void setJoinedOn(LocalDateTime joinedOn) {
		this.joinedOn = joinedOn;
	}
}
