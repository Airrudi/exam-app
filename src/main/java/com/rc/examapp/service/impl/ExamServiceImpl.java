package com.rc.examapp.service.impl;

import com.rc.examapp.dao.ExamDao;
import com.rc.examapp.model.Exam;
import com.rc.examapp.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by R.E.M. Claassen on 27-10-2017.
 */
@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	ExamDao examDao;

	@Override
	public Exam getById(long id) {
		return examDao.getById(id);
	}

	@Override
	public List<Exam> getAll() {
		return examDao.getAll();
	}

	@Override
	@Transactional //TODO: Q: Is it required to make it transactional?
	public Exam save(Exam exam) {
		examDao.save(exam);

		return examDao.getById(exam.getId());

	}
}
