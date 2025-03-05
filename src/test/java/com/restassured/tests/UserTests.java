package com.restassured.tests;

import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.base.BaseTest;
import com.restassured.clients.UserClient;
import com.restassured.models.User;
import com.restassured.utils.LoggerUtil;

import io.restassured.response.Response;

public class UserTests extends BaseTest {
    @Test
    public void testCreateUser() {
        LoggerUtil.logger.info("Starting Test: testCreateUser");

        User user = new User("John", "Engineer");
        LoggerUtil.logger.info("Creating User with name: " + user.getName() + " and job: " + user.getJob());

        Response response = UserClient.createUser(user);
        LoggerUtil.logger.info("Received Response" + response.asString());

        Assert.assertEquals(response.getStatusCode(), 201);
        LoggerUtil.logger.info("Test Passed: User Created Successfully!");

    }
}
