package Test;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest{
    @Test

    public void sortProductsByPrice(){
        Homepage onHomepage = loginWithValidCredentials();
        onHomepage.clickOnOrderMenu().clickOnHighToLowerPrice();


        List<Double> prices = onHomepage.getProductPrices();

        boolean isSortedDescending = true;
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i - 1) < prices.get(i)) {
                isSortedDescending = false;
                break;
            }
        }

        Assert.assertTrue(isSortedDescending, "Price list is not ordered by Price descendant");
    }
    @Test
    public void AddMultipleItems2Cart(){
        Homepage onHomepage = loginWithValidCredentials();
        int initialCartItemCount = 0;
        onHomepage.addProductsToCart(0,1,4);
        int finalCartItemCount = onHomepage.getCartItemCount();
        int expectedCartItemCount = initialCartItemCount + 3;
        Assert.assertEquals(finalCartItemCount, expectedCartItemCount, "Items quantity have not been increased correctly ");

    }
    @Test
    public void addSpecificItem2Cart(){
        Homepage onHomepage = loginWithValidCredentials();
        onHomepage.addSpecificProductSLO();
        String prodName = onHomepage.getProductNameSLO();
        CartPage onCartPage = onHomepage.clickOnCart();
        String expectedPrdName = onCartPage.getItemLabelInCart();
        Assert.assertEquals(prodName,expectedPrdName);

    }

    @Test
    public void completePurcharse(){
        Homepage onHomepage = loginWithValidCredentials();
        onHomepage.addSpecificProductSLO();
        String prodName = onHomepage.getProductNameSLO();
        CartPage onCartPage = onHomepage.clickOnCart();
        String expectedPrdName = onCartPage.getItemLabelInCart();
        Assert.assertEquals(prodName,expectedPrdName);
        CheckOutYourInfoPage onCheckOutYourInfoPage = onCartPage.clickOnCheckOut();
        onCheckOutYourInfoPage.fillFormWithMockData();
        CheckOutOverviewPage onCheckOutOverviewPage = onCheckOutYourInfoPage.clickOnContinue();
        CheckOutCompletePage onCheckOutCompletePage = onCheckOutOverviewPage.clickOnFinish();
        onCheckOutCompletePage.getCompleteMessage();


    }
}
