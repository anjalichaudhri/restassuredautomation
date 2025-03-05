package com.restassured.base;

import org.testng.annotations.BeforeClass;

import com.restassured.config.BaseConfig;

import io.restassured.RestAssured;

public class BaseTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BaseConfig.BASE_URL;
    }
 }
