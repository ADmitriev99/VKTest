package lanit.ipr;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesSingleton {

    private static Properties properties;

    public static Properties getInstance() {
        if (properties == null) {
            properties = Properties();
        }
        return properties;
    }

    private PropertiesSingleton() {
    }

    public static Properties Properties() {

        String path = "src/test/resources/resource.properties";
        java.util.Properties properties = new java.util.Properties();
        try (
                FileInputStream fileInputStream = new FileInputStream(path)) {
            try {
                properties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
