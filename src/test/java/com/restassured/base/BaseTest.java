package com.restassured.base;

import org.testng.annotations.BeforeClass;

import com.restassured.config.BaseConfig;

import io.restassured.RestAssured;
import io.qameta.allure.restassured.AllureRestAssured;

public class BaseTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BaseConfig.BASE_URL;
        RestAssured.filters(new AllureRestAssured()); // Attach Allure logging
    }
 }
