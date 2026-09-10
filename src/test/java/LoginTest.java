import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;



public class LoginTest extends BaseTest {


    @Test(description = "Verify valid user can log in successfully")
    public void validLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(loginData.get("validUsername").asText());
        loginPage.enterPassword(loginData.get("validPassword").asText());
        loginPage.clickLogin();
        Assert.assertEquals(
                loginPage.getProductTitle(),expectedMessages.get("productTitle").asText());

    }

    @Test(description = "Verify login fails with an invalid username and valid password")
    public void invalidUserNameAndValidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(loginData.get("invalidUsername").asText());
        loginPage.enterPassword(loginData.get("validPassword").asText());
        loginPage.clickLogin();
        Assert.assertEquals(
                loginPage.getLoginErrorMessage(),
                expectedMessages.get("invalidCredentials").asText());
    }

    @Test(description = "Verify login fails with a valid username and invalid password")
    public void validUserNameAndInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(loginData.get("validUsername").asText());
        loginPage.enterPassword(loginData.get("invalidPassword").asText());
        loginPage.clickLogin();
        Assert.assertEquals(
                loginPage.getLoginErrorMessage(),
                expectedMessages.get("invalidCredentials").asText());
    }

    @Test(description = "Verify login fails with an invalid username and invalid password")
    public void invalidUserNameAndInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(loginData.get("invalidUsername").asText());
        loginPage.enterPassword(loginData.get("invalidPassword").asText());
        loginPage.clickLogin();
        Assert.assertEquals(
                loginPage.getLoginErrorMessage(),
                expectedMessages.get("invalidCredentials").asText());
    }

    @Test(description = "Verify validation message is displayed when username is empty")
    public void emptyUserNameAndValidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(loginData.get("emptyUsername").asText());
        loginPage.enterPassword(loginData.get("validPassword").asText());
        loginPage.clickLogin();
        Assert.assertEquals(
                loginPage.getLoginErrorMessage(),
                expectedMessages.get("usernameRequired").asText());
    }

    @Test(description = "Verify validation message is displayed when password is empty")
    public void validUserNameAndEmptyPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(loginData.get("validUsername").asText());
        loginPage.enterPassword(loginData.get("emptyPassword").asText());
        loginPage.clickLogin();
        Assert.assertEquals(
                loginPage.getLoginErrorMessage(),
                expectedMessages.get("passwordRequired").asText());
    }

    @Test(description = "Verify username required message is displayed when both username and password are empty")
    public void emptyUserNameAndEmptyPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(loginData.get("emptyUsername").asText());
        loginPage.enterPassword(loginData.get("emptyPassword").asText());
        loginPage.clickLogin();
        Assert.assertEquals(
                loginPage.getLoginErrorMessage(),
                expectedMessages.get("usernameRequired").asText());
    }

    @Test(description = "Verify locked out user cannot log in")
    public void lockedOutUserTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(loginData.get("lockedOutUser").asText());
        loginPage.enterPassword(loginData.get("validPassword").asText());
        loginPage.clickLogin();
        Assert.assertEquals(
                loginPage.getLoginErrorMessage(),
                expectedMessages.get("lockedOut").asText());
    }

}
