package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    public final String URL = "https://www.vivacom.bg/bg/";

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    WebElement cookies;
    @FindBy(xpath = "//*[@id='main-big-menu']/li[2]/a")
    WebElement devices;
    @FindBy(xpath = "//*[@id='main-big-menu']/li[2]/ul/li[1]/div/div[2]/a")
    WebElement mobileDevices;
    @FindBy(xpath = "//*[@id='filter-manufacturer']/label[1]/em")
    WebElement appleCheckbox;
    @FindBy(xpath = "//*[@id='filter-colors.color']/label[1]/em")
    WebElement blueDevice;
    @FindBy(xpath = "//*[contains(@href,'/apple-iphone-15-plus-128gb')]")
    WebElement appleIphone15;
    @FindBy(xpath = "//form[@id='jsRemoveItemForm-2930694']//em[@class='vivacom-icons icon-close_x']")
    WebElement removeWomanIphone;
    @FindBy(xpath = "//*[@id='jsRemoveItemForm-2930671']/button")
    WebElement removeIphoneGB;
    @FindBy(xpath = "//*[@id='shopping-cart-span']/div[1]/aside/div[1]/div/div[5]/div[3]/div")
    WebElement currentCustomerOrder;

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

    public void acceptCookies() {
        clickElement(cookies);
    }

    public void clickMobiledevices() {
        clickElement(mobileDevices);
    }

    public void clickAppleCheckbox() {
        clickElement(appleCheckbox);
    }

    public void clickdevice() {
        isPageLoaded(devices);
        clickElement(devices);
    }

    public void clickAppleIphone() {
        clickElement(appleIphone15);
    }

    public void verifyUrl() {
        verifyUrl(URL);
    }


    public void clickBlueDevice() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", blueDevice);
        clickElement(blueDevice);
    }

    public void clickRemoveWomanIphone() {
        smallWait.until(ExpectedConditions.elementToBeClickable(removeWomanIphone));
        clickElement(removeWomanIphone);
    }
}



