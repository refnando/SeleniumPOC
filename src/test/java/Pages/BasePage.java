package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor jse;

    public BasePage(WebDriver driver){
        String browser = "firefox";

        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/Utils/Data/Drivers/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/java/Utils/Data/Drivers/geckodriver");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new FirefoxDriver(firefoxOptions);

        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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