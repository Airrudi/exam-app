package com.rc.examapp.exam;

/**
 * Created by RC on 1-11-2017.
 */
public interface ExamService {

	Exam save(Exam exam);
	Exam findOne(Long examId);

	int calculateScore(Exam exam); // For both UserExam and Exam
	int calculateScore(UserExam userExam); // For both UserExam and Exam
	double calculateGrade(UserExam userExam);

	boolean isExamCompleted(UserExam userExam);

}
