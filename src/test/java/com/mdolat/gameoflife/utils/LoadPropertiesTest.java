package com.mdolat.gameoflife.utils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoadPropertiesTest {

    @Test
    public void shouldLoadRequiredProperties() {
        ImmutableList<String> properties = ImmutableList.of("LIVE_CELL", "DEATH_CELL");
        ImmutableMap<String, String> loadedProperties = LoadProperties.loadProperties("/application.properties", properties);

        for (String property : properties) {
            assertTrue(loadedProperties.containsKey(property));
        }
    }

}