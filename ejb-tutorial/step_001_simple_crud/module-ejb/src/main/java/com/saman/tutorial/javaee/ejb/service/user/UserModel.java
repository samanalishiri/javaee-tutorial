package com.saman.tutorial.javaee.ejb.service.user;

import com.saman.tutorial.javaee.ejb.service.model.AbstractModel;

public class UserModel extends AbstractModel<Integer> {

    private Integer id;

    private String username;

    private String password;

    private String email;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
