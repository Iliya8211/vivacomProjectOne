package tests;


import pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ClickDevices extends BaseTestMethod {


    @Test
    public void clickDevice() throws InterruptedException {
        System.out.println("1.Open site URL");
        HomePage homePage = new HomePage(driver);
        homePage.openSiteUrl();

        System.out.println("2. Accept cookies");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.acceptCookies();

        System.out.println("3. Click devices");
        loginPage.clickdevice();

        System.out.println("4.Click mobile devices");
        loginPage.clickMobiledevices();

        System.out.println("5.Click on apple check box");
        loginPage.clickAppleCheckbox();

        System.out.println("6.Click on blue devices");
        Thread.sleep(3000);
        loginPage.clickBlueDevice();

        System.out.println("7.Click on Apple Iphone15");
        loginPage.clickAppleIphone();

        System.out.println("8.Click single payment on Unlimited 300 plan");
        AppleIphone appleIphone = new AppleIphone(driver);
        appleIphone.clickSinglePayment();

        System.out.println("9. Click on no fixed service");
        appleIphone.clickNoFixedService();

        System.out.println("10. Click on byu button");
        appleIphone.clickBuy();

        System.out.println("11.Verification you are in trail");
        Cart cart = new Cart(driver);
        String text = "Информация за поръчката";
        String actualText = cart.conformationOfTrail();
        Assert.assertEquals(actualText, text, "You are not in the shopping chart");

        System.out.println("12. Continue with shopping");
        cart.keepShopping();

        System.out.println("13.Click devices again");
        homePage.clickLogo();
        loginPage.clickdevice();

        System.out.println("14.Click accessories");
        homePage.clickAccessories();

        System.out.println("15. Click apple checkbox again");
        homePage.appleAgainCheckBox();

        System.out.println("16. Click checkbox price over forty");
        homePage.clickPriceOverForty();

        System.out.println("17. Click on iphone plus fine woman");
        Thread.sleep(2000);
        homePage.clickIphoneWoman();

        System.out.println("18. Press buy btn for iphone women");
        homePage.clickBuyWomanIphone();

        System.out.println("19. Verification of order woman iphone case");
        String text1 = "Информация за поръчката";
        String actualText1 = cart.confirmBuyWomanIphone();
        Assert.assertEquals(actualText1, text1, "You didnt order woman iPhone");

        Double totalPriceDouble = cart.getTotalOrderPrice();
        System.out.println("Total order price is: " + totalPriceDouble);

        if (totalPriceDouble > 1900) {
            cart.removeSecondItemInTheCart();
        }


        System.out.println("22.Check invisibility of btn order as a current customer");
        Assert.assertTrue(cart.disabilityOfCurrentCustomer());

        System.out.println("23.Check invisibility of btn new client order");
        Assert.assertTrue(cart.newCustomerDisabilityOfBtn());

        System.out.println("24.Check visibility of check box common rules for mobile services");
        Assert.assertTrue(cart.commonRulesCheckBox());

        System.out.println("25.Click on check box common rules for mobile services");
        cart.clickCheckBoxCommonRule();

        System.out.println("26.Remove iPhone from shopping cart");
        driver.navigate().refresh();
        cart.removeIphoneFromShoppingCart();
        cart.waitForCartToBeEmpty();

        System.out.println("Final verification that shopping cart is empty");
        String tx = "В момента кошницата ви е празна";
        String actualTx = cart.verificationOfEmptyShoppingCart();
        Assert.assertEquals(actualTx, tx, "Message does not match.");
    }

}


