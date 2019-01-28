package com.saman.tutorial.javaee.ejb.service.model;

import com.saman.tutorial.javaee.ejb.service.user.UserModel;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractModel<T> implements Serializable {

    public abstract T getId();

    public abstract void setId(T id);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(getId(), userModel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
