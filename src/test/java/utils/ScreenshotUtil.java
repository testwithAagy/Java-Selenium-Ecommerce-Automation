package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String screenshotName) {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        return takesScreenshot
                .getScreenshotAs(OutputType.BASE64);
    }
}