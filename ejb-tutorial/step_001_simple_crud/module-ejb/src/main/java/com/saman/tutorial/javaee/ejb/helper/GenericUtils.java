package com.saman.tutorial.javaee.ejb.helper;

import java.lang.reflect.ParameterizedType;

public final class GenericUtils {

    private GenericUtils() {
    }

    public static  <T> Class<T> getActualTypeArgument(Class<? > clazz, int genericIndex) {
        return (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[genericIndex];
    }
}
