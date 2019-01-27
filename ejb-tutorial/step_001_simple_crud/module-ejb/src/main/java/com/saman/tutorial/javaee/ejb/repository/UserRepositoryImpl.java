package com.saman.tutorial.javaee.ejb.repository;

import com.saman.tutorial.javaee.ejb.domain.UserEntity;

import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
@Transactional(Transactional.TxType.REQUIRED)
public class UserRepositoryImpl extends AbstractRepository<Integer, UserEntity> implements UserRepository {

}
