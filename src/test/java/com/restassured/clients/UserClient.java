package com.restassured.clients;

import com.restassured.models.User;

import io.restassured.response.Response;
import io.restassured.RestAssured;

public class UserClient {
    public static Response createUser(User user) {
        return RestAssured.given()
            .header("Content-Type", "application/json")
            .body(user)
            .when()
            .post("/api/users");
    }
}
