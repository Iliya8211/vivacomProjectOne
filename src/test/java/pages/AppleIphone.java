package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppleIphone extends BasePage {

    @FindBy(xpath = "(//*[@value='Unlimited 300'])[1]/..//*[@name='relatedOfferCashPriceRadioInputName']/..")
    WebElement singlePayment;
    @FindBy(css = "#xSellBtn")
    WebElement noFixedService;
    @FindBy(xpath = "//*[@id='faciaDataHighResView']/div[4]/div[1]/button")
    WebElement buyIphone;

    public AppleIphone(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded(WebElement element) {
        boolean isDisplayed = false;
        try {
            WebElement until = smallWait.until(ExpectedConditions.visibilityOf(element));
            isDisplayed = true;
        } catch (TimeoutException timeoutException) {
            System.out.println("Homepage not presented in " + 30 + " seconds.");
        }
        return isDisplayed;
    }

    public void clickSinglePayment() {
        isPageLoaded(singlePayment);
        clickElement(singlePayment);
    }

    public void clickNoFixedService() {
        clickElement(noFixedService);
    }

    public void clickBuy() {
        clickElement(buyIphone);
    }
}



