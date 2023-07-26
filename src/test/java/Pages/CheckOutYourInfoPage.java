package Pages;

import net.andreinc.mockneat.MockNeat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutYourInfoPage  extends BasePage{

    public CheckOutYourInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ("#first-name"))
    private WebElement firstNameTextField;

    @FindBy(css = ("#last-name"))
    private WebElement lastNameTextField;

    @FindBy(css = ("#postal-code"))
    private WebElement postCodeTextField;

    @FindBy(css = ("#continue"))
    private WebElement continueButton;

    public WebElement getFirstNameTextField(){
        return firstNameTextField;
    }

    public WebElement getLastNameTextField(){
        return lastNameTextField;
    }

    public WebElement getPostCodeTextField(){
        return postCodeTextField;
    }

    public WebElement getContinueButton(){
        return continueButton;
    }

    public void fillFormWithMockData() {
        MockNeat mock = MockNeat.threadLocal();
        String firstName = mock.names().first().val();
        String lastName = mock.names().last().val();
        String postalCode = mock.ints().range(10000, 99999).val().toString();

        getFirstNameTextField().sendKeys(firstName);
        System.out.println(firstName);
        getLastNameTextField().sendKeys(lastName);
        System.out.println(lastName);
        getPostCodeTextField().sendKeys(postalCode);
        System.out.println(postalCode);
    }

    public CheckOutOverviewPage clickOnContinue(){
        getContinueButton().click();
        return PageFactory.initElements(driver, CheckOutOverviewPage.class);
    }
}
