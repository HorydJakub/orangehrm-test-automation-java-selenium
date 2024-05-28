package com.jakubhoryd.core.utils;

import java.io.*;
import java.util.*;

public class PropertiesLoader {
    public static class PropertiesLoadingException extends RuntimeException {
        public PropertiesLoadingException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    private static Properties loadProperties() throws IOException {
        try (InputStream inputStream = new FileInputStream("src/test/resources/openhrm.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        }
    }

    public static String loadProperty(String propertyName) {
        try {
            Properties properties = loadProperties();
            return properties.getProperty(propertyName);
        } catch (IOException e) {
            throw new PropertiesLoadingException("Failed to load property: " + propertyName, e);
        }
    }

    public static <T> T loadProperty(String propertyName, Class<T> propertyType) {
        try {
            Properties properties = loadProperties();
            String value = properties.getProperty(propertyName);

            // parse values based on propertyType
            switch (propertyType.getSimpleName()) {
                case "String":
                    return propertyType.cast(value);
                case "Integer":
                    return propertyType.cast(Integer.parseInt(value));
                case "Boolean":
                    return propertyType.cast(Boolean.parseBoolean(value));
                default:
                    throw new PropertiesLoadingException("Unsupported property type: " + propertyType.getSimpleName(), null);
            }
        } catch (IOException | NumberFormatException e) {
            throw new PropertiesLoadingException("Failed to load property: " + propertyName, e);
        }
    }
}
