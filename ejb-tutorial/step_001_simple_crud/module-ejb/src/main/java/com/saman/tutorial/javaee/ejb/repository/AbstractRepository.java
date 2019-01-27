package com.saman.tutorial.javaee.ejb.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import static com.saman.tutorial.javaee.ejb.helper.GenericUtils.getActualTypeArgument;

public abstract class AbstractRepository<ID, E> implements CrudRepository<ID, E> {

    private static final int GENERIC_ENTITY_INDEX = 1;

    @PersistenceContext(unitName = "javaeetutorial")
    private EntityManager em;

    private Class<E> entity;

    public AbstractRepository() {
        this.entity = getActualTypeArgument(getClass(), GENERIC_ENTITY_INDEX);
    }


    @Override
    public E findById(ID id) {
        return em.find(entity, id);
    }

    @Override
    public List<E> findAll() {
        CriteriaQuery<E> criteriaQuery = createCriteriaQuery();
        return em.createQuery(criteriaQuery.select(criteriaQuery.from(entity))).getResultList();
    }

    protected CriteriaQuery<E> createCriteriaQuery() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        return criteriaBuilder.createQuery(entity);
    }
}
