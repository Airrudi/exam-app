package com.rc.examapp.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by R.E.M. Claassen on 2-11-2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
