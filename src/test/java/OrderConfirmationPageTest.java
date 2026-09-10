import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

public class OrderConfirmationPageTest extends BaseTest {

    private final ConfigReader configReader = new ConfigReader();

    @Test(description = "Verify the order confirmation page is displayed after completing checkout")
    public void verifyOrderConfirmationPage() {

        loginAsValidUser();

        ProductPage productPage = new ProductPage(driver);
        productPage.selectProduct(productData.get("bikeLight").asText());
        productPage.addToCart();
        productPage.clickShoppingCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterFirstName(checkoutData.get("firstName").asText());
        checkoutPage.enterLastName(checkoutData.get("lastName").asText());
        checkoutPage.enterPostalCode(checkoutData.get("postalCode").asText());
        checkoutPage.clickContinue();

        CheckoutOverviewPage overviewPage =
                new CheckoutOverviewPage(driver);
        overviewPage.clickFinish();

        OrderConfirmationPage orderConfirmationPage =
                new OrderConfirmationPage(driver);


        Assert.assertEquals(
                driver.getCurrentUrl(),
                configReader.getProperty("baseUrl") + "checkout-complete.html"
        );

        Assert.assertEquals(
                orderConfirmationPage.getAppLogo(),
                expectedMessages.get("appLogo").asText()
        );

        Assert.assertEquals(
                orderConfirmationPage.getPageTitle(),
                expectedMessages.get("orderConfirmationTitle").asText()
        );

        Assert.assertTrue(
                orderConfirmationPage.isPonyExpressDisplayed()
        );

        Assert.assertEquals(
                orderConfirmationPage.getCompleteHeader(),
                expectedMessages.get("orderConfirmationHeader").asText()
        );

        Assert.assertEquals(
                orderConfirmationPage.getCompleteText(),
                expectedMessages.get("orderDispatchMessage").asText()
        );

        Assert.assertEquals(
                orderConfirmationPage.getBackHomeButtonText(),
                expectedMessages.get("backHomeButton").asText()
        );

        Assert.assertEquals(
                orderConfirmationPage.getGeneratePdfButtonText(),
                expectedMessages.get("generatePdfOrderButton").asText()
        );
    }

    @Test(description = "Verify the Back Home button navigates to the Products page")
    public void verifyBackHomeButtonNavigation() {

        loginAsValidUser();

        ProductPage productPage = new ProductPage(driver);
        productPage.selectProduct(productData.get("bikeLight").asText());
        productPage.addToCart();
        productPage.clickShoppingCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterFirstName(checkoutData.get("firstName").asText());
        checkoutPage.enterLastName(checkoutData.get("lastName").asText());
        checkoutPage.enterPostalCode(checkoutData.get("postalCode").asText());
        checkoutPage.clickContinue();

        CheckoutOverviewPage overviewPage =
                new CheckoutOverviewPage(driver);
        overviewPage.clickFinish();

        OrderConfirmationPage orderConfirmationPage =
                new OrderConfirmationPage(driver);

        orderConfirmationPage.clickBackHome();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                configReader.getProperty("baseUrl") + "inventory.html"
        );
    }
    @Test(description = "Verify the Generate PDF Order button is displayed and can be clicked")
    public void verifyGeneratePdfOrderButton() {

        loginAsValidUser();

        ProductPage productPage = new ProductPage(driver);
        productPage.selectProduct(productData.get("bikeLight").asText());
        productPage.addToCart();
        productPage.clickShoppingCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterFirstName(checkoutData.get("firstName").asText());
        checkoutPage.enterLastName(checkoutData.get("lastName").asText());
        checkoutPage.enterPostalCode(checkoutData.get("postalCode").asText());
        checkoutPage.clickContinue();

        CheckoutOverviewPage overviewPage =
                new CheckoutOverviewPage(driver);
        overviewPage.clickFinish();

        OrderConfirmationPage orderConfirmationPage =
                new OrderConfirmationPage(driver);

        Assert.assertEquals(
                orderConfirmationPage.getGeneratePdfButtonText(),
                expectedMessages.get("generatePdfOrderButton").asText()
        );

        orderConfirmationPage.clickGeneratePdfOrder();
    }
}