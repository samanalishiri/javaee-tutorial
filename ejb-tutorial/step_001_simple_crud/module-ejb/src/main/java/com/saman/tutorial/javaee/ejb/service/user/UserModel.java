package com.saman.tutorial.javaee.ejb.service.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.saman.tutorial.javaee.ejb.service.model.AbstractModel;

public class UserModel extends AbstractModel<Integer> {

    private Integer id;

    private String username;

    private String password;

    private String email;

    public UserModel() {
    }

    @JsonIgnore
    private UserModel(Builder builder) {
        setId(builder.id);
        setUsername(builder.username);
        setPassword(builder.password);
        setEmail(builder.email);
    }

    @JsonIgnore
    public static Builder newBuilder() {
        return new Builder();
    }

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

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @JsonIgnoreType
    public static final class Builder {
        private Integer id;
        private String username;
        private String password;
        private String email;

        private Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public UserModel build() {
            return new UserModel(this);
        }
    }
}
