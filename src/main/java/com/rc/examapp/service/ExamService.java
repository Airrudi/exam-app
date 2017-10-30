package com.rc.examapp.service;

import com.rc.examapp.model.Exam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by R.E.M. Claassen on 27-10-2017.
 */


public interface ExamService {

	Exam getById(long id);
	List<Exam> getAll();

	Exam save(Exam exam);

	// List<Exam> getCreatedByUser(User user);
}
