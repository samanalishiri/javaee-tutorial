package com.saman.tutorial.javaee.web;

import com.saman.tutorial.javaee.ejb.service.UserModel;
import com.saman.tutorial.javaee.ejb.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("user")
@Consumes({"application/json"})
@Produces({"application/json"})
public class UserResource {

    @Inject
    private UserService service;

    @GET
    @Path("{id}")
    public UserModel findById(@PathParam("id") Integer id) {
        return service.findById(id);
    }

    @GET
    @Path("all")
    public List<UserModel> findAll() {
        return service.findAll();
    }
}
