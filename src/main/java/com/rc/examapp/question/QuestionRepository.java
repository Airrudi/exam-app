package com.rc.examapp.question;

import org.springframework.data.repository.CrudRepository;

/**
 * @author R.E.M. Claassen
 * @version 1.0
 */
public interface QuestionRepository extends CrudRepository<Question, Long> {
}
