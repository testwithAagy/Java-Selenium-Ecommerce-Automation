package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

public class DriverFactory {

    public static WebDriver createDriver() {

        ConfigReader configReader = new ConfigReader();
        String browser = configReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            options.setExperimentalOption(
                    "prefs",
                    Map.of(
                            "credentials_enable_service", false,
                            "profile.password_manager_leak_detection", false
                    )
            );

            return new ChromeDriver(options);
        }

        if (browser.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        }
        if (browser.equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        }

        throw new RuntimeException("Unsupported browser: " + browser);

    }
}