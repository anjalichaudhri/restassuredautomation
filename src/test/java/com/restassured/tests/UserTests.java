package com.restassured.tests;

import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restassured.base.BaseTest;
import com.restassured.clients.UserClient;
import com.restassured.models.User;
import com.restassured.utils.LoggerUtil;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;

public class UserTests extends BaseTest {
    @DataProvider(name="userData")
    public Object[][] userDataProvider() {
        return new Object[][] {
            {"John", "Engineer"},
            {"Alice", "Doctor"},
            {"Bob", "Teacher"}
        };
    }

    @Test(priority = 1, invocationCount = 2)
    @Description("Test to create a new user")
    @Epic("User Management")
    @Feature("Create User")
    @Story("As a user, I should be able to create a new user")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateUser() {
        LoggerUtil.logger.info("Starting Test: testCreateUser");

        User user = new User("John", "Engineer");
        LoggerUtil.logger.info("Creating User with name: " + user.getName() + " and job: " + user.getJob());

        Response response = UserClient.createUser(user);
        LoggerUtil.logger.info("Received Response" + response.asString());

        Assert.assertEquals(response.getStatusCode(), 201);
        LoggerUtil.logger.info("Test Passed: User Created Successfully!");

    }

    @Test(priority = 2)
    @Feature("User API")
    @Description("Test to create a user")
    public void testCreateUserAllure() {
        Allure.step("Creating user payload");
        User user = new User("John", "Engineer");

        Allure.step("Sending API request to create user");
        Response response = UserClient.createUser(user);

        Allure.step("Validating response");
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(priority = 3, dataProvider = "userData")
    @Feature("Multiple Users Test api")
    @Description("Test to create multiple users using Data Provider")
    @Epic("User Management")
    @Feature("Create User")
    @Story("As a user, I should be able to create different users")
    @Severity(SeverityLevel.NORMAL)
    public void testCreateUserWithMultipleData(String name, String password) {
        User user = new User(name, password);
        
        Allure.step("Sending API request with user: " + name);
        Response response = UserClient.createUser(user);
        
        Allure.step("Validating response status code");
        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
