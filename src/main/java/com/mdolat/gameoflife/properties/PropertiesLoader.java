package com.mdolat.gameoflife.properties;

import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import io.vavr.control.Option;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class PropertiesLoader {

    private static final Map<String, String> properties = loadProperties();
    private static final String DEFAULT_PROPERTIES_LOCATION = "/application.properties";

    private PropertiesLoader() {}

    public static Option<String> getProperty(String propertyName) {
        return properties.get(propertyName);
    }

    private static Map<String, String> loadPropertiesFrom(final String propertiesFile){
        String propertiesFileLocation = Optional.ofNullable(propertiesFile).orElse(DEFAULT_PROPERTIES_LOCATION);
        try (InputStream resourceAsStream = PropertiesLoader.class.getResourceAsStream(propertiesFileLocation)) {
            Properties properties = new Properties();
            properties.load(resourceAsStream);


            HashMap<String, String> propertiesBuilder = HashMap.empty();
            for (java.util.Map.Entry<Object, Object> entry : properties.entrySet()) {
                Object o = entry.getKey();
                Object o2 = entry.getValue();
                propertiesBuilder = propertiesBuilder.put((String) o, (String) o2);
            }

            return propertiesBuilder;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return HashMap.empty();
    }

    private static Map<String, String> loadProperties(){
        return loadPropertiesFrom(DEFAULT_PROPERTIES_LOCATION);
    }
}
