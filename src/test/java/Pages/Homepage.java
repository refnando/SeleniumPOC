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
    private WebElement productsPanel;

    @FindBy(xpath = ("//button[@id='react-burger-menu-btn']"))
    private WebElement burgerIcon;
    @FindBy(xpath = ("//a[@id='inventory_sidebar_link']"))
    private WebElement allItemsOption;

    @FindBy(xpath = ("//a[@id='about_sidebar_link']"))
    private WebElement aboutOption;

    @FindBy(xpath = ("//a[@id='logout_sidebar_link']"))
    private WebElement logoutOption;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    @FindBy(className = "btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(xpath = ("//button[@id='add-to-cart-sauce-labs-onesie']"))
    private WebElement addToCartSLO;

    @FindBy(css = ("div.page_wrapper div:nth-child(1) div.header_container:nth-child(1) div.header_secondary_container div.right_component > span.select_container"))
    private WebElement selectMenu;

    @FindBy(css = ("div.page_wrapper div.header_container:nth-child(1) div.header_secondary_container div.right_component span.select_container select.product_sort_container > option:nth-child(4)"))
    private WebElement priceH2L;

    @FindBy(css = "div.inventory_item_price")
    private List<WebElement> productPrices;

    public Boolean productsPanelDisplayed(){
        try{
            waitUntilBeDisplayed(getProductsPanel());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public WebElement getProductsPanel() {
        return productsPanel;
    }

    public WebElement getBurgerIcon() {
        return burgerIcon;
    }

    public WebElement getAllItemsOption() {
        return allItemsOption;
    }

    public WebElement getAboutOption() {
        return aboutOption;
    }

    public WebElement getLogoutOption() {
        return logoutOption;
    }

    public List<WebElement> getProductNames() {
        return productNames;
    }

    public List<WebElement> getAddToCartButtons() {
        return addToCartButtons;
    }

    public WebElement getCartBadge() {
        return cartBadge;
    }

    public WebElement getAddToCartSLO() {
        return addToCartSLO;
    }

    public WebElement getSelectMenu(){
        return selectMenu;
    }

    public WebElement getPriceH2L(){
        return priceH2L;
    }

    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement productPrice : productPrices) {
            String priceText = productPrice.getText().replace("$", "");
            prices.add(Double.parseDouble(priceText));
        }
        return prices;
    }

    public Homepage clickOnBurgerIcon(){
        getBurgerIcon().click();
        waitUntilBeDisplayed(getLogoutOption());
        return PageFactory.initElements(driver, Homepage.class);
    }

    public LoginPage clickOnLogout(){
     //   waitUntilBeDisplayed(logoutOption);
        getLogoutOption().click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public Homepage clickOnOrderMenu(){
        waitUntilBeDisplayed(getSelectMenu());
        getSelectMenu().click();
        return  PageFactory.initElements(driver, Homepage.class);
    }

    public Homepage clickOnHighToLowerPrice(){
        waitUntilBeDisplayed(getPriceH2L());
        getPriceH2L().click();
        return  PageFactory.initElements(driver, Homepage.class);
    }

    public void addProductsToCart(int... productIndices){
        for(int index : productIndices){
            getAddToCartButtons().get(index).click();
        }
    }

    public int getCartItemCount() {
        String cartItemCountText = getCartBadge().getText();
        return Integer.parseInt(cartItemCountText);
    }

    public String getProductNameSLO() {
        return getProductNames().get(4).getText();
    }

    public Homepage addSpecificProductSLO(){
        String productName = getProductNameSLO();
        getAddToCartSLO().click();
        waitUntilBeDisplayed(getCartBadge());
        getCartItemCount();
        return PageFactory.initElements(driver, Homepage.class);
    }

    public CartPage clickOnCart(){
        getCartBadge().click();
        return PageFactory.initElements(driver, CartPage.class);
    }

}
