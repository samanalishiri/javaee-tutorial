package com.saman.tutorial.javaee.ejb.service;

import java.util.List;

public interface CrudService<ID, E, M> {
    M findById(ID id);

    List<M> findAll();
}
