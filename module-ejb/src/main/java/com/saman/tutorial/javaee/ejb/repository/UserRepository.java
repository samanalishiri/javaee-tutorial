package com.saman.tutorial.javaee.ejb.repository;

import com.saman.tutorial.javaee.ejb.domain.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

@Stateless
public class UserRepository implements IUserRepository {

    @PersistenceContext(unitName = "javaeetutorial")
    private EntityManager em;


    @Override
    public UserEntity findById(Integer id) {
        return null;
    }
}
