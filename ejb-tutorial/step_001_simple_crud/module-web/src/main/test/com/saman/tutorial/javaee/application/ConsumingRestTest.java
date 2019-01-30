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
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class ConsumingRestTest {

    private final Logger logger = Logger.getLogger("ConsumingRestTest");

    private final String baseUrl = "http://localhost:8080/resources/";

    private final UserModel.Builder userBuilder = UserModel.newBuilder();

    private Client client;

    @Before
    public void setup() {
        client = ClientBuilder.newClient();
    }

    @After
    public void teardown() {
        client.close();
    }

    private void init() {

        postModel("user/save", userBuilder.id(1).username("admin").email("admin@gmail.com").password("123").build()).close();
        postModel("user/save", userBuilder.id(2).username("user").email("user@gmail.com").password("123").build()).close();
        postModel("user/save", userBuilder.id(3).username("guest").email("guest@gmail.com").password("123").build()).close();
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
            List<String> userModelsAsString = UserConverter.covert(response.readEntity(JsonArray.class))
                    .stream()
                    .map(UserModel::toString)
                    .collect(Collectors.toList());

            logger.info(String.join("\n", userModelsAsString));
        }
        response.close();

        truncate();
    }

    private Response getRequest(String url) {
        return client.target(baseUrl + url)
                .request()
                .property("Accept", "application/json")
                .property("Content-type", "application/json")
                .buildGet()
                .invoke();
    }

    private Response postModel(String url, UserModel model) {
        return client.target(baseUrl + url)
                .request()
                .property("Accept", "application/json")
                .property("Content-type", "application/json")
                .buildPost(Entity.json(model))
                .invoke();
    }
}