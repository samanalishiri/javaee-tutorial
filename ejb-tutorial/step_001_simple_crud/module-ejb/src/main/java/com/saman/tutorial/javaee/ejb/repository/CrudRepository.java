package com.saman.tutorial.javaee.ejb.repository;

import com.saman.tutorial.javaee.ejb.domain.AbstractEntity;

import java.util.List;

public interface CrudRepository<ID, E extends AbstractEntity<ID>> {

    ID save(E e);

    E findById(ID id);

    List<E> findAll();

    void delete(ID id);
}
