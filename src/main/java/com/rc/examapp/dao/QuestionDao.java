package com.rc.examapp.dao;

import com.rc.examapp.model.Question;

import java.util.List;

/**
 * Created by R.E.M. Claassen on 30-10-2017.
 */
public interface QuestionDao {

	List<Question> getAll();
	Question getById(long id);
}
