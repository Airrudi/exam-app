package com.rc.examapp.question;

/**
 * Created by RC on 1-11-2017.
 */
public interface QuestionService {

	Question save(Question question);
	Question findOne(Long questionId);
}
