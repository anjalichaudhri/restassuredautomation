package com.restassured.clients;


import com.restassured.models.RegisterRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RegisterClient {
    private static final String REGISTER_ENDPOINT = "/api/register";

    public static Response registerUser(RegisterRequest request) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(request)
                .when()
                .post(REGISTER_ENDPOINT);
    }
}
