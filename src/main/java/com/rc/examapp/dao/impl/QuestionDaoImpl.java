package com.rc.examapp.dao.impl;

import com.rc.examapp.dao.QuestionDao;
import com.rc.examapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by R.E.M. Claassen on 30-10-2017.
 */

@Repository
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	EntityManager em;

	@Override
	public List<Question> getAll() {

		TypedQuery<Question> query = em.createQuery("SELECT q FROM Question q", Question.class);
		return query.getResultList();
	}

	@Override
	public Question getById(long id) {
		return em.find(Question.class, id);
	}
}
