package com.saman.tutorial.javaee.ejb.repository;

import com.saman.tutorial.javaee.ejb.domain.UserEntity;

import javax.ejb.Local;

@Local
public interface IUserRepository extends CrudRepository<Long, UserEntity> {

}