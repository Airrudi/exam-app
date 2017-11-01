package com.rc.examapp.question;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author RC
 * @version 1.0
 */

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
}
