package com.rc.examapp.exam;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author RC
 * @version 1.0
 */

@Repository
public interface ExamRepository extends CrudRepository<Exam, Long> {
}
