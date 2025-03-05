package com.restassured.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    public static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    public static Logger getLogger() {
        return logger;
    }
}
