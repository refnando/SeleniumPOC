package Test;

import Pages.Homepage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void ValidCredentials(){
        LoginPage onLoginPage = new LoginPage(driver);
        Homepage  onHomePage = onLoginPage.LoginWithValidCredentials(properties.getProperty("user"), properties.getProperty("password"));

     //   Assert.assertTrue(onHomePage.productsPanelDisplayed());
    }
}
