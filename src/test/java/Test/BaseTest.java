package Test;
import Utils.Driver;
import Utils.LoadProperties;
import Utils.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public LoadProperties properties;
    public ScreenShot sc;

    @BeforeSuite
    public void setUp(){
        properties = new LoadProperties();
        driver = new Driver(properties.getProperty("driver")).getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        sc = new ScreenShot(driver);
    }

    @BeforeTest
    public void testSetup(){
        driver.get(properties.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void testTearDown(ITestResult result){
        sc.takeScreenShot(result);
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}
