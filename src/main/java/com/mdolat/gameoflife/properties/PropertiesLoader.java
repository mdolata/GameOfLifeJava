package com.mdolat.gameoflife.properties;

import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class PropertiesLoader {

    private static final ImmutableMap<String, String> properties = loadProperties();
    private static final String DEFAULT_PROPERTIES_LOCATION = "/application.properties";

    private PropertiesLoader() {}

    public static String getProperty(String propertyName) {
        return properties.getOrDefault(propertyName, "Not defined value");
    }

    public static ImmutableMap<String, String> loadPropertiesFrom(final String propertiesFile){
        String propertiesFileLocation = Optional.ofNullable(propertiesFile).orElse(DEFAULT_PROPERTIES_LOCATION);
        try (InputStream resourceAsStream = PropertiesLoader.class.getResourceAsStream(propertiesFileLocation)) {
            Properties properties = new Properties();
            properties.load(resourceAsStream);

            ImmutableMap.Builder<String, String> propertiesBuilder = ImmutableMap.builder();
            properties.forEach((k,v) -> propertiesBuilder.put((String) k, (String) v));

            return propertiesBuilder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ImmutableMap.of();
    }

    public static ImmutableMap<String, String> loadProperties(){
        return loadPropertiesFrom(DEFAULT_PROPERTIES_LOCATION);
    }
}
