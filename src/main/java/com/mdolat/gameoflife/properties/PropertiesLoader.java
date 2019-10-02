package com.mdolat.gameoflife.properties;

import io.vavr.Tuple;
import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import io.vavr.collection.Stream;
import io.vavr.control.Option;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

public class PropertiesLoader {

    private static final String DEFAULT_PROPERTIES_LOCATION = "/application.properties";
    private static final Map<String, String> properties = loadProperties();

    private PropertiesLoader() {
    }

    public static Option<String> getProperty(String propertyName) {
        return properties.get(propertyName);
    }

    static Map<String, String> loadPropertiesFrom(final String propertiesFile) {
        String propertiesFileLocation = Optional.ofNullable(propertiesFile).orElse(DEFAULT_PROPERTIES_LOCATION);

        return readProperties(propertiesFileLocation);
    }

    private static Map<String, String> readProperties(String propertiesFileLocation) {
        return HashMap.ofEntries(
                Stream.concat(getPropertiesSet(propertiesFileLocation))
                        .map(entry -> Tuple.of((String) entry.getKey(), (String) entry.getValue())));

    }

    private static Set<java.util.Map.Entry<Object, Object>> getPropertiesSet(String propertiesFileLocation) {
        Properties properties = new Properties();
        try (InputStream resourceAsStream = PropertiesLoader.class.getResourceAsStream(propertiesFileLocation)) {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.entrySet();
    }

    private static Map<String, String> loadProperties() {
        return loadPropertiesFrom(DEFAULT_PROPERTIES_LOCATION);
    }
}
