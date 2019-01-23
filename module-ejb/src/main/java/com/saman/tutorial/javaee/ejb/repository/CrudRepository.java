package com.saman.tutorial.javaee.ejb.repository;

public interface CrudRepository<ID, E> {
    E findById(ID id);
}
