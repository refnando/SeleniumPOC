package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class Homepage  extends  BasePage{
    public Homepage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = ("//span[contains(text(),'Products')]"))
    public WebElement productsPanel;

    @FindBy(xpath = ("//button[@id='react-burger-menu-btn']"))
    public WebElement burgerIcon;
    @FindBy(xpath = ("//a[@id='inventory_sidebar_link']"))
    public WebElement allItemsOption;

    @FindBy(xpath = ("//a[@id='about_sidebar_link']"))
    public WebElement aboutOption;

    @FindBy(xpath = ("//a[@id='logout_sidebar_link']']"))
    public WebElement logoutOption;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> productNames;

    @FindBy(className = "btn_inventory")
    public List<WebElement> addToCartButtons;

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBadge;

    @FindBy(xpath = ("//button[@id='add-to-cart-sauce-labs-onesie']"))
    public WebElement addToCartSLO;

//    public Boolean productsPanelDisplayed(){
//        try{
//            wait.until(ExpectedConditions.visibilityOf(productsPanel));
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }

    public Homepage clickOnBurgerIcon(){
        burgerIcon.click();
        return PageFactory.initElements(driver, Homepage.class);
    }

    public LoginPage clickOnLogout(){
        waitUntilBeDisplayed(logoutOption);
        logoutOption.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public void addProductsToCart(int... productIndices){
        for(int index : productIndices){
            addToCartButtons.get(index).click();
        }
    }

    public int getCartItemCount() {
        String cartItemCountText = cartBadge.getText();
        return Integer.parseInt(cartItemCountText);
    }

    public Homepage addSpecificProductSLO(){
        addToCartSLO.click();
        waitUntilBeDisplayed(cartBadge);
        getCartItemCount();
        return PageFactory.initElements(driver, Homepage.class);
    }

}
