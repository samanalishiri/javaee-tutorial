package com.saman.tutorial.javaee.ejb.repository.user;

import com.saman.tutorial.javaee.ejb.domain.UserEntity;
import com.saman.tutorial.javaee.ejb.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Integer, UserEntity> {

}
