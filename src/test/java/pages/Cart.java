package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Cart extends BasePage {

    @FindBy(xpath = "//*[@id='shopping-cart-span']/div[1]/aside/div[1]/div/h3")
    WebElement myOrder;

    @FindBy(xpath = "//*[@id='shopping-cart-span']/div[1]/aside/div[1]/div/div[5]/div[4]/div/a")
    WebElement continueShopping;

    @FindBy(xpath = "//*[@id='shopping-cart-span']/div[1]/aside/div[1]/div/h3")
    WebElement conformationWomanIphone;

    @FindBy(xpath = "//*[contains(@class,'e-care-home-big-bill-price-digits js-limit-exceed')]")
    WebElement totalOrderPrice;

    @FindBy(xpath = "(//*[@class='vivacom-icons icon-close_x'])[1]")
    WebElement secondItemInTheCartRemoveButton;

    @FindBy(xpath = "//*[@id='shopping-cart-span']/div[1]/aside/div[1]/div/div[5]/div[2]")
    WebElement orderLikeCurrentCustomer;

    @FindBy(xpath = "//*[@id='shopping-cart-span']/div[1]/aside/div[1]/div/div[5]/div[3]")
    WebElement newCustomerOrderBtnDisability;

    @FindBy(xpath = "//*[@id='shopping-cart-span']/div[1]/aside/div[1]/div/div[5]/div[1]/div/label")
    WebElement commonRulesCheckBox;

    @FindBy(xpath = "(//*[@class='vivacom-icons icon-close_x'])[1]")
    WebElement removeIphoneFromCart;

    @FindBy(xpath = "//*[@class='empty-shopping-cart']/h3")
    WebElement emptyShoppingCart;


    public Cart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded(WebElement element) {
        boolean isDisplayed = false;
        try {
            WebElement until = smallWait.until(ExpectedConditions.visibilityOf(element));
            isDisplayed = true;
        } catch (TimeoutException timeoutException) {
            System.out.println("Cart not presented in 30 seconds.");
        }
        return isDisplayed;
    }

    public String conformationOfTrail() {
        String actualText = myOrder.getText().trim();
        return actualText;
    }

    public void keepShopping() {
        clickElement(continueShopping);
    }

    public String confirmBuyWomanIphone() {
        String actualText1 = conformationWomanIphone.getText().trim();
        return actualText1;
    }

    public double getTotalOrderPrice() {
        String totalPriceText = totalOrderPrice.getText();
        String valueOnly = totalPriceText.substring(0, totalPriceText.length() - 3);
        return Double.valueOf(valueOnly);
    }

    public void removeSecondItemInTheCart() {
        clickElement(secondItemInTheCartRemoveButton);
    }

    public boolean disabilityOfCurrentCustomer() {
        return orderLikeCurrentCustomer.isEnabled();
    }

    public boolean newCustomerDisabilityOfBtn() {
        clickElement(newCustomerOrderBtnDisability);
        return newCustomerOrderBtnDisability.isEnabled();
    }

    public boolean commonRulesCheckBox() {
        clickElement(commonRulesCheckBox);
        return commonRulesCheckBox.isDisplayed();
    }

    public void clickCheckBoxCommonRule() {
        clickElement(commonRulesCheckBox);
    }

    public void removeIphoneFromShoppingCart() {
        isPageLoaded(removeIphoneFromCart);
        clickElement(removeIphoneFromCart);
    }

    public void waitForCartToBeEmpty() {
        isPageLoaded(emptyShoppingCart);
    }

    public String verificationOfEmptyShoppingCart() {
        String actualTx = emptyShoppingCart.getText().trim();
        return actualTx;
    }

}


