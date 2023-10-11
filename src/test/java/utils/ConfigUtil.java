package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
    public static String getPropertyValue(String key) throws IOException {
        Properties properties = new Properties();
        String propertyFileName = "/config.properties";
        InputStream inputStream = ConfigUtil.class.getResourceAsStream(propertyFileName);
        if (inputStream != null) {
            properties.load(inputStream);
        }
        return properties.getProperty(key);
    }
}
