package Utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private final String driverName;

    public Driver(String driverNameName) {
        this.driverName = driverNameName.toLowerCase();
    }

    public WebDriver getDriver() {
        switch (driverName) {
            case "chrome" -> {
                return new ChromeDriver();
            }
            case "firefox" -> {
                return new FirefoxDriver();
            }
            case "edge" -> {
                return new EdgeDriver();
            }
            default -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                WebDriver driver = new ChromeDriver(options);
                driver.manage().window().setSize(new Dimension(1920, 1080));
                return driver;
            }
        }
    }


}
