package com.mdolat.gameoflife.properties;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mdolat.gameoflife.properties.PropertiesLoader;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertiesLoaderTest {

    @Test
    public void shouldLoadRequiredProperties() {
        ImmutableList<String> properties = ImmutableList.of("live_cell", "death_cell");
        ImmutableMap<String, String> loadedProperties = PropertiesLoader.loadProperties();

        for (String property : properties) {
            assertTrue(loadedProperties.containsKey(property));
            assertNotEquals("Not defined value", PropertiesLoader.getProperty(property));
        }
    }

}