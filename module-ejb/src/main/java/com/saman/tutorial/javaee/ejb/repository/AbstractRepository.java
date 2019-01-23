package com.saman.tutorial.javaee.ejb.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractRepository<ID, E> implements CrudRepository<ID, E> {

    @PersistenceContext(unitName = "javaeetutorial")
    private EntityManager em;

    private Class<E> entity;

    @Override
    public E findById(ID id) {
        return null;
    }
}
