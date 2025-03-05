package com.restassured.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object obj) throws IOException {
        return objectMapper.writeValueAsString(obj);
    }
}
