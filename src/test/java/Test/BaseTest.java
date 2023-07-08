package Test;
import Utils.Driver;
import Utils.LoadProperties;
import Utils.ScreenShot;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public LoadProperties properties;
    public ScreenShot sc;
    public ExtentReports extentReports;
    public ExtentTest extentTest;

    @BeforeSuite
    public void setUp(){
        properties = new LoadProperties();
        driver = new Driver(properties.getProperty("driver")).getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        sc = new ScreenShot(driver);

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @BeforeTest
    public void testSetup(){
        driver.get(properties.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void testTearDown(ITestResult result){
        sc.takeScreenShot(result);
        driver.manage().deleteAllCookies();

        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, "Test passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, "Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(sc.getScreenshotPath()).build());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "Test Skipped");
        }
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
        extentReports.flush();
    }

}