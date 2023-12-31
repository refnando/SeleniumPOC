package Utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShot {

    private final WebDriver driver;

    public ScreenShot(WebDriver driver){
        this.driver = driver;
    }

    public void takeScreenShot(ITestResult result){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String nowDate = now.format(formatter);

        if (!result.isSuccess()){
            try {
                Path screenshotPath = Path.of("ScreenShots", result.getName() + nowDate + ".png");
                Files.createDirectories(screenshotPath.getParent());
                Files.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).toPath(), screenshotPath, StandardCopyOption.REPLACE_EXISTING);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public String getScreenshotPath() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String nowDate = now.format(formatter);

        String screenshotPath = "";
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path targetDirectory = Paths.get("ScreenShots");
            Files.createDirectories(targetDirectory);
            Path targetPath = targetDirectory.resolve("screenshot_" + nowDate + ".png");
            Files.copy(screenshotFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            screenshotPath = targetPath.toAbsolutePath().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }



}