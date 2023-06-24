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
    public WebElement userTextField;
    @FindBy(xpath = ("//input[@id='password']"))
    public WebElement pwdTextField;
    @FindBy(xpath = ("//input[@id='login-button']"))
    public WebElement loginButton;



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

    public Homepage LoginWithValidCredentials(String user, String pwd){
     //   isUserTextFieldDisplayed();
        userTextField.sendKeys(user);
        pwdTextField.sendKeys(pwd);
        loginButton.click();
        return PageFactory.initElements(driver, Homepage.class);
    }

    public LoginPage loginWithInvalidCredentials(String user, String pwd){
        userTextField.sendKeys(user);
        pwdTextField.sendKeys(pwd);
        loginButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

}
