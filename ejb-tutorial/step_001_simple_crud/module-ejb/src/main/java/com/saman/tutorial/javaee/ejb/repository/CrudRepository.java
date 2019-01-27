package com.saman.tutorial.javaee.ejb.repository;

import java.util.List;

public interface CrudRepository<ID, E> {
    E findById(ID id);

    List<E> findAll();
}
