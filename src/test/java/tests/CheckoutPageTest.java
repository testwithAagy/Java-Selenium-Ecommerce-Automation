package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductPage;

public class CheckoutPageTest extends BaseTest {


    @Test(description = "Verify user can navigate to the Checkout: Your Information page")
    public void verifyCheckoutPageNavigation() {

        loginAsValidUser();

        ProductPage productPage = new ProductPage(driver);
        productPage.selectProduct(productData.get("bikeLight").asText());
        productPage.addToCart();
        productPage.clickShoppingCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        Assert.assertEquals(
                checkoutPage.getCheckoutInformationTitle(),
                expectedMessages.get("checkoutInformationTitle").asText()
        );
    }

    @Test(description = "Verify user can enter valid checkout information and continue")
    public void verifyValidCheckoutInformationCanBeEntered() {

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

        Assert.assertEquals(
                checkoutPage.getCheckoutOverviewTitle(),
                expectedMessages.get("checkoutOverviewTitle").asText()
        );
    }


    @Test(description = "Verify validation message is displayed when first name is empty")
    public void verifyCheckoutFailsWhenFirstNameIsEmpty() {

        loginAsValidUser();
        ProductPage productPage = new ProductPage(driver);
        productPage.selectProduct(productData.get("bikeLight").asText());
        productPage.addToCart();
        productPage.clickShoppingCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterLastName(checkoutData.get("lastName").asText());
        checkoutPage.enterPostalCode(checkoutData.get("postalCode").asText());
        checkoutPage.clickContinue();

        Assert.assertEquals(
                checkoutPage.getErrorMessage(),
                expectedMessages.get("firstNameRequired").asText()
        );
    }

    @Test(description = "Verify validation message is displayed when last name is empty")
    public void verifyCheckoutFailsWhenLastNameIsEmpty() {

        loginAsValidUser();

        ProductPage productPage = new ProductPage(driver);
        productPage.selectProduct(productData.get("bikeLight").asText());
        productPage.addToCart();
        productPage.clickShoppingCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterFirstName(checkoutData.get("firstName").asText());
        checkoutPage.enterPostalCode(checkoutData.get("postalCode").asText());
        checkoutPage.clickContinue();

        Assert.assertEquals(
                checkoutPage.getErrorMessage(),
                expectedMessages.get("lastNameRequired").asText()
        );
    }
    @Test(description = "Verify validation message is displayed when postal code is empty")
    public void verifyCheckoutFailsWhenPostalCodeIsEmpty() {

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
        checkoutPage.clickContinue();

        Assert.assertEquals(
                checkoutPage.getErrorMessage(),
                expectedMessages.get("postalCodeRequired").asText()
        );
    }
}
