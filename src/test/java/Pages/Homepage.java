package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Homepage  extends  BasePage{
    public Homepage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
