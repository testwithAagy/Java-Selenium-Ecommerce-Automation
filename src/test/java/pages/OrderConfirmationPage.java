package pages;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderConfirmationPage extends BasePage{

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        }

    private By appLogo = By.className("app_logo");
    private By pageTitle = By.cssSelector("[data-test='title']");
    private By ponyExpress = By.cssSelector("[data-test='pony-express']");
    private By completeHeader = By.cssSelector("[data-test='complete-header']");
    private By completeText = By.cssSelector("[data-test='complete-text']");
    private By backHomeButton = By.cssSelector("[data-test='back-to-products']");
    private By generatePdfButton = By.cssSelector("[data-test='generate-pdf-order']");


    public String getAppLogo() {
        return getTextWhenVisible(appLogo);
    }

    public String getPageTitle() {
        return getTextWhenVisible(pageTitle);
    }

    public boolean isPonyExpressDisplayed() {
           return isVisible(ponyExpress);
        }
    public String getCompleteHeader() {
        return getTextWhenVisible(completeHeader);
    }

    public String getCompleteText() {
            return getTextWhenVisible(completeText);
        }

    public String getBackHomeButtonText() {
        return getTextWhenVisible(backHomeButton);
    }

    public String getGeneratePdfButtonText() {
            return getTextWhenVisible(generatePdfButton);
        }

    public void clickBackHome() {
        clickWhenReady(backHomeButton);
    }

    public void clickGeneratePdfOrder() {
        clickWhenReady(generatePdfButton);
    }
    }
