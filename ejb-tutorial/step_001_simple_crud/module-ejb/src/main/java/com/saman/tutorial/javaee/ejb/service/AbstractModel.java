package com.saman.tutorial.javaee.ejb.service;

import java.io.Serializable;

public abstract class AbstractModel<T> implements Serializable {

    public abstract T getId();

    public abstract void setId(T id);
}
