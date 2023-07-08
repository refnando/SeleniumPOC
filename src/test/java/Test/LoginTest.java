package Test;

import Pages.Homepage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    @Test
    public void ValidCredentials() {
        LoginPage onLoginPage = new LoginPage(driver);
        Homepage onHomePage = onLoginPage.LoginWithValidCredentials(properties.getProperty("user"), properties.getProperty("password"));

        Assert.assertTrue(onHomePage.productsPanelDisplayed());
    }

    @Test
    public void InvalidCredentials() {

        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        LoginPage onLoginPage = new LoginPage(driver);
        onLoginPage.loginWithInvalidCredentials(properties.getProperty("invaliduser"), properties.getProperty("password"));
        Assert.assertEquals(onLoginPage.getInvalidCredentialsErrorMessage(), expectedErrorMessage);
    }

    @Test
    public void LoginLogout() {
        ValidCredentials();
        Homepage onHomePage = new Homepage(driver);
        onHomePage
                .clickOnBurgerIcon()
                .clickOnLogout();
    }
}
