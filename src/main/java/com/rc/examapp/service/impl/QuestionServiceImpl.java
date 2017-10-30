package com.rc.examapp.service.impl;

import com.rc.examapp.dao.QuestionDao;
import com.rc.examapp.model.Question;
import com.rc.examapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by R.E.M. Claassen on 30-10-2017.
 */

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionDao questionDao;

	@Override
	public List<Question> getAll() {
		return questionDao.getAll();
	}

	@Override
	public Question getById(long id) {
		return questionDao.getById(id);
	}
}
