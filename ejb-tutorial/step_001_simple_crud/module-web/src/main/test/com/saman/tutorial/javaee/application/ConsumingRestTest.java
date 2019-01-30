package com.saman.tutorial.javaee.application;

import com.saman.tutorial.javaee.ejb.service.user.UserConverter;
import com.saman.tutorial.javaee.ejb.service.user.UserModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class ConsumingRestTest {

    public static final Logger LOGGER = Logger.getLogger("ConsumingRestTest");

    private static String baseUrl = "http://localhost:8080/resources/";

    private Client client;

    @Before
    public void setup() {
        client = ClientBuilder.newClient();
    }

    private void init() {
        UserModel.Builder userBuilder = UserModel.newBuilder();

        postModel(userBuilder.id(1).username("admin").email("admin@gmail.com").password("123").build(),
                "user/save");
        postModel(userBuilder.id(2).username("user").email("user@gmail.com").password("123").build(),
                "user/save");
        postModel(userBuilder.id(3).username("guest").email("guest@gmail.com").password("123").build(),
                "user/save");
    }

    private void truncate() {
        getRequest("user/delete/1").close();
        getRequest("user/delete/2").close();
        getRequest("user/delete/3").close();
    }

    @Test
    public void getAllUsers() {
        init();

        Response response = getRequest("user/find/all");
        if (response.hasEntity()) {
            JsonArray jsonArray = response.readEntity(JsonArray.class);
            List<UserModel> users = jsonArray.stream().map(UserConverter::covert).collect(Collectors.toList());
            LOGGER.info(String.join("\n", users.stream().map(UserModel::toString).collect(Collectors.toList())));
        }
        response.close();

        truncate();
    }

    @After
    public void teardown() {
        client.close();
    }

    private Response getRequest(String url) {
        return client.target(baseUrl + url)
                .request()
                .property("Accept", "application/json")
                .property("Content-type", "application/json")
                .buildGet()
                .invoke();
    }

    private void postModel(UserModel model, String url) {
        Response response = client.target(baseUrl + url)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .property("Accept", "application/json")
                .property("Content-type", "application/json")
                .buildPost(Entity.json(model))
                .invoke();

        response.close();
    }
}