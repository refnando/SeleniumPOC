package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jse;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        jse = (JavascriptExecutor) driver;
    }

    public void waitUntilElementBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilPageLoad() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public WebElement waitUntilBeDisplayed(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    // Métodos getter y setter para los campos privados

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public JavascriptExecutor getJse() {
        return jse;
    }

    public void setJse(JavascriptExecutor jse) {
        this.jse = jse;
    }
}
