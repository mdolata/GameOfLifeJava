package com.mdolat.gameoflife.utils;

import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class LoadProperties {

    public static ImmutableMap<String, String> loadProperties(String propertiesFile, List<String> fields) {
        if (propertiesFile == null) {
            propertiesFile = "/application.properties";
        }

        Properties prop = new Properties();

        try (InputStream resourceAsStream = LoadProperties.class.getResourceAsStream(propertiesFile)) {
            prop.load(resourceAsStream);
            prop.forEach((k, v) -> System.out.println(k + " ->" + v + "<-"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
        fields.forEach(field -> builder.put(field, prop.getProperty(field.toLowerCase())));

        return builder.build();
    }
}
