package utils;

import com.google.common.collect.ImmutableList;
import org.reflections.Reflections;
import properties.PropertyHaving;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;
import java.util.Set;

public class LoadProperties {

    static void loadProperties(String propertiesFile) {
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
        try (InputStream resourceAsStream = input){//MainApp.class.getResourceAsStream(propertiesFile)){
            prop.load(resourceAsStream);

            prop.forEach((k, v) -> System.out.println(k + " ->" + v + "<-"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        Reflections reflections = new Reflections("board");
        Set<Class<? extends PropertyHaving>> subTypesOf = reflections.getSubTypesOf(PropertyHaving.class);
        subTypesOf.forEach(aClass -> System.out.println(aClass.getSimpleName()));

        subTypesOf.forEach(aClass -> ImmutableList
                                        .copyOf(aClass.getDeclaredFields())
                                        .stream()
                                        .filter(field -> field.getType().equals(String.class))

                                        .forEach(field -> {
                                            String value = prop.getProperty(field.getName().toLowerCase(), "");
                                            setFinalStatic(field, value);
                                        }));


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
