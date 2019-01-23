package com.saman.tutorial.javaee.ejb.service;

import com.saman.tutorial.javaee.ejb.repository.IUserRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserService implements IUserService {

    @EJB
    private IUserRepository repository;
}
