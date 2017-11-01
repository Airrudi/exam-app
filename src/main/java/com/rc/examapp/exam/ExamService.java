package com.rc.examapp.exam;

/**
 * Created by RC on 1-11-2017.
 */
public interface ExamService {

	Exam save(Exam exam);
	Exam findOne(Long examId);

}
