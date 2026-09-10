package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.databind.JsonNode;
import utils.ExtentTestListener;
import utils.JsonDataReader;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExtentReportManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.DriverFactory;


@Listeners(ExtentTestListener.class)

public class BaseTest {

    public WebDriver driver;

    private final ConfigReader configReader = new ConfigReader();

    private final JsonDataReader reader = new JsonDataReader();
    private final JsonNode testData = reader.readJson();

    protected final JsonNode loginData = testData.get("login");
    protected final JsonNode productData = testData.get("products");
    protected final JsonNode checkoutData = testData.get("checkout");
    protected final JsonNode orderData = testData.get("order");
    protected final JsonNode expectedMessages = testData.get("expectedMessages");



    @BeforeSuite
    public void startReport() {
        ExtentReportManager.getReportInstance();
    }


    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
        driver.get(configReader.getProperty("baseUrl"));
    }

    protected void loginAsValidUser() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(
                loginData.get("validUsername").asText()
        );

        loginPage.enterPassword(
                loginData.get("validPassword").asText()
        );

        loginPage.clickLogin();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }


    @AfterSuite
    public void finishReport() {
        ExtentReportManager.getReportInstance().flush();
    }
}
