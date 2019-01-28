package com.saman.tutorial.javaee.ejb.service.user;

import com.saman.tutorial.javaee.ejb.domain.UserEntity;
import com.saman.tutorial.javaee.ejb.service.CrudService;
import com.saman.tutorial.javaee.ejb.service.user.UserModel;

public interface UserService extends CrudService<Integer, UserEntity, UserModel> {
}
