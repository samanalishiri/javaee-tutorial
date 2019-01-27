package com.saman.tutorial.javaee.ejb.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity<T> implements Serializable {

    public abstract T getId();

    public abstract void setId(T id);
}
