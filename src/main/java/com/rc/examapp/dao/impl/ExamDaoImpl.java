package com.rc.examapp.dao.impl;

import com.rc.examapp.dao.ExamDao;
import com.rc.examapp.model.Exam;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by R.E.M. Claassen on 27-10-2017.
 */
@Repository
public class ExamDaoImpl implements ExamDao {

	@Override
	public Exam getById(long id) {
		return new Exam("Wiskunde", "Henk", 60);
	}

	@Override
	public List<Exam> getAll() {
		List<Exam> exams = new ArrayList<>();

		Exam exam1 = new Exam("Wiskunde", "Henk", 60);
		Exam exam2 = new Exam("Natuurkunde", "Piet", 70);
		Exam exam3 = new Exam("Scheikunde", "Henk", 55);

		exams.add(exam1);
		exams.add(exam2);
		exams.add(exam3);

		return exams;
	}
}

