package com.saman.tutorial.javaee.ejb.service.user;

import com.saman.tutorial.javaee.ejb.repository.user.UserRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository repository;

    @Override
    public UserModel findById(Integer id) {
        return UserConverter.covert(repository.findById(id));
    }

    @Override
    public List<UserModel> findAll() {
        return UserConverter.covert(repository.findAll());
    }
}
