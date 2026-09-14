package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private final Properties properties;

    public ConfigReader() {
        properties = new Properties();

        try (InputStream inputStream =
                     getClass().getClassLoader()
                             .getResourceAsStream("config/config.properties")) {

            if (inputStream == null) {
                throw new RuntimeException(
                        "config.properties not found in test resources"
                );
            }

            properties.load(inputStream);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to read config.properties", e
            );
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}