package Utils;

import org.openqa.selenium.WebDriver;


public class Driver {
    private final String driverName;

    public Driver(String driverName) {
        this.driverName = driverName.toLowerCase();
    }

    public WebDriver getDriver() {
        BrowserType browserType;

        switch (driverName) {
            case "chrome":
                browserType = BrowserType.CHROME;
                break;
            case "firefox":
                browserType = BrowserType.FIREFOX;
                break;
            case "edge":
                browserType = BrowserType.EDGE;
                break;
            default:
                browserType = BrowserType.CHROME;
                break;
        }

        return DriverFactory.createDriver(browserType);
    }
}
