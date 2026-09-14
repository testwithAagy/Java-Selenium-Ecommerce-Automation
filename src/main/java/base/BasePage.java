package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void click (By locator){
        driver.findElement(locator).click();
    }
    public void enterText(By locator , String text){
        driver.findElement(locator).sendKeys(text);
    }
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void clickWhenReady(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public String getTextWhenVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).getText();
    }
    public boolean isVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).isDisplayed();
    }
}
