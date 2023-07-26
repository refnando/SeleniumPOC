package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends BasePage{
    public CheckOutCompletePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = ("//span[contains(text(),'Checkout: Complete!')]"))
    private WebElement completeLabel;

    public WebElement getCompleteLabel(){
        return completeLabel;
    }

    public String getCompleteMessage(){
        waitUntilBeDisplayed(getCompleteLabel());
        return getCompleteLabel().getText();
    }
}
