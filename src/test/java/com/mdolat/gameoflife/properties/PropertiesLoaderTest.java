package com.mdolat.gameoflife.properties;

import io.vavr.collection.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertiesLoaderTest {

    @Test
    public void shouldLoadRequiredProperties() {
        List<String> properties = List.of("live_cell", "death_cell");

        for (String property : properties) {
            assertTrue(PropertiesLoader.getProperty(property).isDefined());
        }
    }

}