package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    @FindBy(xpath = "//*[@class='web-only navbar-brand logo']")
    WebElement logo;
    @FindBy(css = "//*[@id='vivacom-devices-navbar']/a")
    WebElement againDevices;

    @FindBy(xpath = "//*[@href='/online/bg/shop/devices/listing?navigation=product-category-accessories']")
    WebElement accessories;

    @FindBy(xpath = "//*[@id='filter-manufacturer']/label[1]/em")
    WebElement checkBoxAppleAgain;

    @FindBy(xpath = "//*[@id='filter-price']/label[3]/em")
    WebElement priceOverFortyCheckBox;

    @FindBy(xpath = "//*[text()='APPLE iPhone 15 Plus FineWoven Taupe']/..")
    WebElement iphoneWoman;

    @FindBy(xpath = "//*[@id='faciaDataHighResView']/div[4]/div[1]/button")
    WebElement buyWomanIphone;
    private final String URL = "http://www.vivacom.bg/bg/";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openSiteUrl() {
        driver.get(URL);
    }

    public boolean isPageLoaded(WebElement element) {
        boolean isDisplayed = false;
        try {
            WebElement until = smallWait.until(ExpectedConditions.visibilityOf(element));
            isDisplayed = true;
        } catch (TimeoutException timeoutException) {
            System.out.println("Homepage not presented in 30 seconds.");
        }
        return isDisplayed;
    }

    public void clickLogo() {
        clickElement(logo);
    }

    public void clickDevicesAgain() {
        clickElement(againDevices);
    }

    public void clickAccessories() {
        isPageLoaded(accessories);
        clickElement(accessories);
    }

    public void appleAgainCheckBox() {
        clickElement(checkBoxAppleAgain);
    }

    public void clickPriceOverForty() {
        JavascriptExecutor tv = (JavascriptExecutor) driver;
        tv.executeScript("arguments[0].scrollIntoView();", priceOverFortyCheckBox);
        clickElement(priceOverFortyCheckBox);
    }

    public void clickIphoneWoman() {
        clickElement(iphoneWoman);
    }

    public void clickBuyWomanIphone() {
        clickElement(buyWomanIphone);
    }

}

