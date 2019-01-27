package com.saman.tutorial.javaee.ejb.service;

import com.saman.tutorial.javaee.ejb.domain.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class UserConverter {

    private UserConverter() {
    }

    public static UserModel covert(UserEntity entity) {
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setEmail(entity.getEmail());

        return model;
    }

    public static List<UserModel> covert(List<UserEntity> entities) {
        return entities.stream().map(UserConverter::covert).collect(Collectors.toList());
    }
}
