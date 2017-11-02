package com.rc.examapp.question;

import com.rc.examapp.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by R.E.M. Claassen on 2-11-2017.
 */

public class UserAnswer extends Answer {

//	@ManyToOne
//	@JoinColumn(name = "user_id")
	private User user;

	public UserAnswer() {
		super();
	}

	public UserAnswer(String text, User user){
		super(text);
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
