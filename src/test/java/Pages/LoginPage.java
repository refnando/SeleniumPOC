package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(xpath = "(//input[@id='user-name'])")
    private WebElement userTextField;
    @FindBy(xpath = ("//input[@id='password']"))
    private WebElement pwdTextField;
    @FindBy(xpath = ("//input[@id='login-button']"))
    private WebElement loginButton;
    @FindBy(css = ("div.login_container div.login_wrapper div.login_wrapper-inner div.form_column div.login-box form:nth-child(1) div.error-message-container.error:nth-child(3) > h3:nth-child(1)"))
    private WebElement invalidCredentialsError;



    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public Boolean isUserTextFieldDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try{
            wait.until(ExpectedConditions.visibilityOf(userTextField));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void clearCredentialFields(){
        getUserTextField().clear();
        getPwdTextField().clear();
    }

    public Homepage LoginWithValidCredentials(String user, String pwd){
        clearCredentialFields();
        getUserTextField().sendKeys(user);
        getPwdTextField().sendKeys(pwd);
        getLoginButton().click();
        return PageFactory.initElements(driver, Homepage.class);
    }

    public LoginPage loginWithInvalidCredentials(String user, String pwd){
        clearCredentialFields();
        getUserTextField().sendKeys(user);
        getPwdTextField().sendKeys(pwd);
        getLoginButton().click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public String getInvalidCredentialsErrorMessage(){
        return getInvalidCredentialsError().getText();
    }

    // Getters

    public WebElement getUserTextField() {
        return userTextField;
    }

    public WebElement getPwdTextField() {
        return pwdTextField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getInvalidCredentialsError() {
        return invalidCredentialsError;
    }

}
