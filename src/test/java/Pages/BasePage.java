package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor jse;

    public BasePage(WebDriver driver){
        System.setProperty("webdriver.chrome.driver", "/Users/refnando/Documents/Webdriver/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        jse = (JavascriptExecutor)driver;
    }

    public void waitUntilElementBeClickeable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilPageLoad(){
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public WebElement waitUntilBeDisplayed(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

}