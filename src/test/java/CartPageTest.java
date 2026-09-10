import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;
import java.util.Arrays;
import java.util.List;

public class CartPageTest extends BaseTest {


    @Test(description = "Verify the selected product is displayed in the cart")
    public void verifyProductIsDisplayedInCart() {

        loginAsValidUser();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickBikeLight();
        productPage.addToCart();
        productPage.clickShoppingCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(
                cartPage.getCartProductName(),productData.get("bikeLight").asText()

        );
    }


    @Test(description = "Verify the product price is displayed in the cart")
    public void verifyProductPriceIsDisplayedInCart() {

        loginAsValidUser();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickBikeLight();
        productPage.addToCart();   // Add the product to the cart
        productPage.clickShoppingCart(); // Open the shopping cart
        CartPage cartPage = new CartPage(driver);// Create CartPage object
        Assert.assertEquals(
                cartPage.getCartProductPrice(),productData.get("bikeLightPrice").asText()
        );
    }

    @Test(description = "Verify the product description is displayed in the cart")
    public void verifyProductDescriptionIsDisplayedInCart() {

        loginAsValidUser();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickBikeLight();
        productPage.addToCart();
        productPage.clickShoppingCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(cartPage.getCartProductDescription(),productData.get("bikeLightDescription").asText());

    }

    @Test(description = "Verify user can remove a product from the cart")
    public void verifyProductIsRemovedFromCart() {

        loginAsValidUser();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickBikeLight();
        productPage.addToCart();
        productPage.clickShoppingCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.removeProduct();

        Assert.assertFalse(cartPage.isProductDisplayed());

    }
    @Test(description = "Verify user can navigate to the Checkout page from the cart")
    public void verifyCheckoutNavigation() {

        loginAsValidUser();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickBikeLight();
        productPage.addToCart();
        productPage.clickShoppingCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout-step-one")
        );
    }


    @Test(description = "Verify user can continue shopping and return to the Products page")
    public void verifyContinueShoppingNavigatesToProducts() {

        loginAsValidUser();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickBikeLight();
        productPage.addToCart();
        productPage.clickShoppingCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickContinueShopping();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory")
        );
    }


    @Test(description = "Verify multiple products are displayed in the cart")
    public void verifyMultipleProductsAreDisplayedInCart() {

        loginAsValidUser();

        ProductPage productPage = new ProductPage(driver);
        productPage.selectProduct(productData.get("bikeLight").asText());
        productPage.addToCart();
        productPage.clickBackToProducts();
        productPage.selectProduct(productData.get("backpack").asText());
        productPage.addToCart();
        productPage.clickBackToProducts();
        productPage.selectProduct(productData.get("boltTShirt").asText());
        productPage.addToCart();
        productPage.clickShoppingCart();


        CartPage cartPage = new CartPage(driver);
        List<String> actualProductNames = cartPage.getCartProductNameTexts();

        Assert.assertEquals(
                actualProductNames.size(),
                productData.get("expectedCartProductCount").asInt()
        );

        List<String> expectedProductNames = Arrays.asList(
                productData.get("bikeLight").asText(),
                productData.get("backpack").asText(),
                productData.get("boltTShirt").asText()
        );


        Assert.assertEquals(actualProductNames, expectedProductNames);
    }
}
