package com.saman.tutorial.javaee.application;

import com.saman.tutorial.javaee.ejb.service.user.UserModel;
import com.saman.tutorial.javaee.ejb.service.user.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

    @POST
    @Path("save")
    public Integer save(UserModel model) {
        return service.save(model);
    }

    @GET
    @Path("find/{id}")
    public UserModel findById(@PathParam("id") Integer id) {
        return service.findById(id);
    }

    @GET
    @Path("find/all")
    public List<UserModel> findAll() {
        return service.findAll();
    }

    @GET
    @Path("delete/{id}")
    public void delete(@PathParam("id") Integer id) {
        service.delete(id);
    }

}
