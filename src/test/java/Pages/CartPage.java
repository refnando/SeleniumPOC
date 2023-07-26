package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ("div.page_wrapper div:nth-child(1) div.header_container div.header_secondary_container > span.title"))
    private WebElement headerText;

    @FindBy(css = ("#item_2_title_link"))
    private WebElement itemLabel;

    @FindBy(css = ("#checkout"))
    private WebElement checkOutButton;


    public WebElement getHeaderText(){
        return headerText;
    }

    public WebElement getItemLabel(){
        return itemLabel;
    }

    public WebElement getCheckOutButton(){
        return checkOutButton;
    }

    public boolean headerDisplayed(){
        try{
            waitUntilBeDisplayed(getHeaderText());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public String getItemLabelInCart(){
        return getItemLabel().getText();
    }

    public CheckOutYourInfoPage clickOnCheckOut(){
        getCheckOutButton().click();
        return PageFactory.initElements(driver, CheckOutYourInfoPage.class);
    }

}
