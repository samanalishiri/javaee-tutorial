package com.saman.tutorial.javaee.ejb.repository;

import com.saman.tutorial.javaee.ejb.domain.UserEntity;

import javax.ejb.Stateless;

@Stateless(mappedName = "userRepository")
public class UserRepository extends AbstractRepository<Long, UserEntity> implements IUserRepository {

}
