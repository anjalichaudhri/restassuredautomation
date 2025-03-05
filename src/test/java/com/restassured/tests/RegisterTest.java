package com.restassured.tests;

import org.testng.annotations.Test;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class RegisterTest {
    @Test
    @Feature("User Registration API")
    @Description("Check Successful User Registration")
    @Severity(SeverityLevel.CRITICAL)
    public void TestLoginUser() {
        Allure.step("Creating Login payload");
        
    }
}
