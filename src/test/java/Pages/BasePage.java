package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor jse;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
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