package com.saman.tutorial.javaee.ejb.service;

import com.saman.tutorial.javaee.ejb.domain.AbstractEntity;

import java.util.List;

public interface CrudService<ID, E extends AbstractEntity<ID>, M> {

    ID save(M m);

    M findById(ID id);

    List<M> findAll();

    void delete(ID id);
}
