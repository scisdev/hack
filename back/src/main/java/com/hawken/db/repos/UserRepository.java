package com.hawken.db.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hawken.db.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
