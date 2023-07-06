package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    public static WebDriver createDriver(BrowserType browserType) {
        WebDriver driver;

        switch (browserType) {
            case CHROME -> {
                System.setProperty("webdriver.chrome.driver", "src/test/java/Utils/Data/Drivers/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
            }
            case FIREFOX -> {
                System.setProperty("webdriver.gecko.driver", "src/test/java/Utils/Data/Drivers/geckodriver");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
            }
            default -> throw new IllegalArgumentException("Invalid browser type specified.");
        }

        return driver;
    }
}
