package com.saman.tutorial.javaee.ejb.domain;

import java.io.Serializable;

public abstract class AbstractEntity<T> implements Serializable {

    public abstract T getId();

    public abstract void setId(T id);
}
