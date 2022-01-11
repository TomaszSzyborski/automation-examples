package com.practice.automationpractice.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties loadProperites() {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesLoader.class.getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
