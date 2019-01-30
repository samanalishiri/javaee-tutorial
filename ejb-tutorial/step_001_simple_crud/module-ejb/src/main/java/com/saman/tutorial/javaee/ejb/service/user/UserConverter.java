package com.saman.tutorial.javaee.ejb.service.user;

import com.saman.tutorial.javaee.ejb.domain.UserEntity;

import javax.json.JsonValue;
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

    public static List<UserModel> covertEntities(List<UserEntity> entities) {
        return entities.stream().map(UserConverter::covert).collect(Collectors.toList());
    }


    public static UserEntity covert(UserModel model) {
        UserEntity entity = new UserEntity();
        entity.setId(model.getId());
        entity.setUsername(model.getUsername());
        entity.setEmail(model.getEmail());

        return entity;
    }

    public static List<UserEntity> covertModels(List<UserModel> models) {
        return models.stream().map(UserConverter::covert).collect(Collectors.toList());
    }

    public static UserModel covert(JsonValue value) {
        UserModel model = new UserModel();
        model.setId(value.asJsonObject().getInt("id"));
        model.setUsername(value.asJsonObject().getString("username"));
        model.setEmail(value.asJsonObject().getString("email"));

        return model;
    }
}
