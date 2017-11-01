package com.rc.examapp.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	ExamRepository examRepository;

	public Exam save(Exam exam){
		return examRepository.save(exam);
	}

	public Exam findOne(Long examId) {
		return examRepository.findOne(examId);
	}

}
