package com.saman.tutorial.javaee.ejb.repository;

import com.saman.tutorial.javaee.ejb.domain.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static com.saman.tutorial.javaee.ejb.helper.CriteriaUtils.createCriteriaQuery;
import static com.saman.tutorial.javaee.ejb.helper.GenericUtils.getActualTypeArgument;

public abstract class AbstractRepository<ID, E extends AbstractEntity<ID>> implements CrudRepository<ID, E> {

    private static final int GENERIC_ENTITY_INDEX = 1;

    @PersistenceContext(unitName = "javaeetutorial")
    private EntityManager em;

    private Class<E> entity;

    public AbstractRepository() {
        this.entity = getActualTypeArgument(getClass(), GENERIC_ENTITY_INDEX);
    }

    @Override
    public ID save(E e) {
        em.persist(e);
        return e.getId();
    }

    @Override
    public E findById(ID id) {
        return em.find(entity, id);
    }

    @Override
    public List<E> findAll() {
        CriteriaQuery<E> criteriaQuery = createCriteriaQuery(em, entity);
        return em.createQuery(criteriaQuery.select(criteriaQuery.from(entity))).getResultList();
    }

    @Override
    public void delete(ID id) {
        em.remove(em.find(entity, id));
    }

}
