package com.saman.tutorial.javaee.ejb.repository.user;

import com.saman.tutorial.javaee.ejb.domain.UserEntity;
import com.saman.tutorial.javaee.ejb.repository.AbstractRepository;

import javax.ejb.Stateless;

@Stateless
public class JpaUserRepositoryImpl extends AbstractRepository<Integer, UserEntity> implements UserRepository {

}
