package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver){
        super(driver);
    }

    private By productNames = By.cssSelector("[data-test='inventory-item-name']");
    private By bikeLight = By.id("item_0_title_link");
    private By productDetailsTitle = By.cssSelector("[data-test='inventory-item-name']");
    private By addToCartButton = By.id("add-to-cart");
    private By shoppingCart = By.cssSelector("[data-test='shopping-cart-link']");
    private By productDescriptions = By.cssSelector("[data-test='inventory-item-desc']");
    private By productPrices = By.cssSelector("[data-test='inventory-item-price']");
    private By sortDropdown = By.cssSelector("[data-test='product-sort-container']");
    private By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private By backToProductsButton = By.cssSelector("[data-test='back-to-products']");


    public List<String> getProductNameTexts() {
        List<String> productNameTexts = new ArrayList<>();

        for (WebElement product : driver.findElements(productNames)) {
            productNameTexts.add(product.getText());
        }

        return productNameTexts;
    }


    public List<String> getProductDescriptionTexts() {
        List<String> productDescriptionTexts = new ArrayList<>();

        for (WebElement product : driver.findElements(productDescriptions)) {
            productDescriptionTexts.add(product.getText());
        }

        return productDescriptionTexts;
    }


    public List<String> getProductPriceTexts() {
        List<String> productPriceTexts = new ArrayList<>();

        for (WebElement product : driver.findElements(productPrices)) {
            productPriceTexts.add(product.getText());
        }

        return productPriceTexts;
    }


    public void clickBikeLight(){
       click(bikeLight);
    }

    public String productDetailsTitle(){
       return  getText(productDetailsTitle);
    }

    public void addToCart(){
        click(addToCartButton);
    }

    public void clickShoppingCart(){
        click(shoppingCart);
    }


    public void sortProductsByNameAToZ() {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByValue("az");
    }

    public void sortProductsByNameZToA() {

        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByValue("za");
    }

    public void sortProductsByPriceLowToHigh() {

        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByValue("lohi");
    }

    public void sortProductsByPriceHighToLow(){
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByValue("hilo");
    }

    public String getCartBadgeCount() {

        return getText(cartBadge);
    }
    public void clickBackToProducts() {

       click(backToProductsButton);
    }

    public void selectProduct(String productName) {

        By product = By.xpath(
                "//a[contains(@id,'title_link')][.//div[@data-test='inventory-item-name' and text()='"
                        + productName + "']]"
        );

        driver.findElement(product).click();
    }
}
