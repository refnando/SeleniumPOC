package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage extends BasePage {

    public CheckOutOverviewPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ("div.page_wrapper div.checkout_summary_container div.cart_list div.cart_item div.cart_item_label a:nth-child(1) > div.inventory_item_name"))
    private WebElement itemNameLabelFinalCO;

    @FindBy(css = ("#finish"))
    private WebElement finishButton;

    public WebElement getItemNameLabelFinalCO(){
        return itemNameLabelFinalCO;
    }

    public WebElement getFinishButton(){
        return finishButton;
    }

    public String getItemLabel(){
        return getItemNameLabelFinalCO().getText();
    }

    public CheckOutCompletePage clickOnFinish(){
        getFinishButton().click();
        return PageFactory.initElements(driver, CheckOutCompletePage.class);
    }




}
