package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    private Properties properties;

    // Provide the correct path to your config.properties file
    private String path = "C:\\Users\\Lenovo\\eclipse-workspace\\CucumberFramework\\config.properties";

    // Constructor
    public ReadConfig() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading config.properties file");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("base_url");
        if (baseUrl != null)
            return baseUrl;
        else
            throw new RuntimeException("Base URL not specified in config file.");
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser != null)
            return browser;
        else
            throw new RuntimeException("Browser not specified in config file.");
    }
}
