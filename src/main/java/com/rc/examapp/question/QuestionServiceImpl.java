package com.rc.examapp.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RC on 1-11-2017.
 */

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	@Override
	public Question save(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Question findOne(Long questionId) {
		return questionRepository.findOne(questionId);
	}
}
