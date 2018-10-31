package com.mdolat.gameoflife.utils;

import com.google.common.collect.ImmutableMap;
import com.mdolat.gameoflife.MainApp;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Properties;

public class LoadProperties {

    public static ImmutableMap<String, String> loadProperties(String propertiesFile, List<String> fields) {
        if (propertiesFile == null){
            propertiesFile = "/application.properties";
        }

        Properties prop = new Properties();


        InputStream input = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };
        try (InputStream resourceAsStream = MainApp.class.getResourceAsStream(propertiesFile)){
            prop.load(resourceAsStream);

            prop.forEach((k, v) -> System.out.println(k + " ->" + v + "<-"));

        } catch (IOException e) {
            e.printStackTrace();
        }



        return null;

    }

    private static void setFinalStatic(Field field, Object newValue) {
        field.setAccessible(true);

        Field modifiersField = null;
        try {
            modifiersField = Field.class.getDeclaredField("modifiers");

            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            field.set(field, newValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
