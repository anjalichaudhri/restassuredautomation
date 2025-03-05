package com.restassured.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.base.BaseTest;
import com.restassured.clients.RegisterClient;
import com.restassured.models.RegisterRequest;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class RegisterTests extends BaseTest {
    @Test
    @Feature("User Registration API")
    @Description("Check Successful User Registration")
    @Severity(SeverityLevel.CRITICAL)
    public void TestSuccessfulRegistration() {
        //Allure.step("Creating Login payload");
        RegisterRequest registerRequest = new RegisterRequest("eve.holt@reqres.in", "pistol");
        Response response = RegisterClient.registerUser(registerRequest);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().getString("token"));
    }

    @Test(description = "Verify registration failure with missing password")
    @Severity(SeverityLevel.NORMAL)
    @Feature("User Registration")
    public void testRegistrationFailure() {
        RegisterRequest request = new RegisterRequest("eve.holt@reqres.in", "");
        Response response = RegisterClient.registerUser(request);

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(response.jsonPath().getString("error"), "Missing password");
    }
}
