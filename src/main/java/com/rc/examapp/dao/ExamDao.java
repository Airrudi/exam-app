package com.rc.examapp.dao;

import com.rc.examapp.model.Exam;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by R.E.M. Claassen on 27-10-2017.
 */

public interface ExamDao {

	List<Exam> getAll();
	Exam getById(long id);
	void save(Exam exam);

}
