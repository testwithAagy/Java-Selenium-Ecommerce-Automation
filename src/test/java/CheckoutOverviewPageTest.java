import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

public class CheckoutOverviewPageTest extends BaseTest {


    private final ConfigReader configReader = new ConfigReader();

    @Test(description = "Verify the selected product is displayed on the Checkout Overview page")
    public void verifySelectedProductIsDisplayedOnCheckoutOverview() {

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

        Assert.assertEquals(
                overviewPage.getProductName(),
                productData.get("bikeLight").asText()
        );
    }


    @Test(description = "Verify product name, description, and price are displayed correctly on the Checkout Overview page")
    public void verifyProductDetailsOnCheckoutOverview() {

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

        Assert.assertEquals(
                overviewPage.getProductName(),
                productData.get("bikeLight").asText()
        );

        Assert.assertEquals(
                overviewPage.getProductDescription(),
                productData.get("bikeLightDescription").asText()
        );

        Assert.assertEquals(
                overviewPage.getProductPrice(),
                productData.get("bikeLightPrice").asText()
        );
    }

    @Test(description = "Verify payment and shipping information are displayed correctly")
    public void verifyPaymentAndShippingInformation() {

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

        Assert.assertEquals(
                overviewPage.getPaymentInformation(),
                orderData.get("paymentInformation").asText()
        );

        Assert.assertEquals(
                overviewPage.getShippingInformation(),
                orderData.get("shippingInformation").asText()
        );
    }

    @Test(description = "Verify order subtotal, tax, and total are calculated correctly")
    public void verifyOrderTotalCalculation() {

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
        String itemTotalText = overviewPage.getItemTotal();
        String taxText = overviewPage.getTax();
        String totalText = overviewPage.getTotal();
        double itemTotal = Double.parseDouble(
                itemTotalText.replace("Item total: $", "")
        );

        double tax = Double.parseDouble(
                taxText.replace("Tax: $", "")
        );

        double actualTotal = Double.parseDouble(
                totalText.replace("Total: $", "")
        );

        double expectedTotal = itemTotal + tax;

        Assert.assertEquals(actualTotal, expectedTotal, 0.01);
    }

    @Test(description = "Verify user can complete the order using the Finish button")
    public void verifyOrderCanBeCompletedUsingFinishButton() {

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

        Assert.assertEquals(
                driver.getCurrentUrl(),
                configReader.getProperty("baseUrl") + "checkout-complete.html"
        );
    }

    @Test(description = "Verify the Cancel button returns the user to the Products page")
    public void verifyCancelButtonReturnsToCart() {

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
        overviewPage.clickCancel();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                configReader.getProperty("baseUrl") + "inventory.html"
        );
    }
}
