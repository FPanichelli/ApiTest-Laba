package com.solvd.carina.demo.demoblaze;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.demoblaze.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Tests implements IAbstractTest {

    @Test(description = "Sign up test")
    @MethodOwner(owner = "FacundoPanichelli")
    public void testRegister() throws IOException {
        HomePage homePage = new HomePage(getDriver());
        NavBar navBar = new NavBar(getDriver());
        homePage.open();
        SignUpModal signUpModal = navBar.signUp();
        Random random = new Random();
        String username = "FPanichelli" + random.nextInt(30000);
        String password = "12345678";
        File credentials = new File("src/test/resources/credentials.txt");
        FileUtils.write(credentials, username + "|" + password, "UTF-8");
        signUpModal.register(username, password);
        Alert alert = getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(), "Sign up successful.");
        alert.accept();
    }

    @Test(description = "Log in test")
    @MethodOwner(owner = "FacundoPanichelli")
    public void testLogin() throws IOException {
        HomePage homePage = new HomePage(getDriver());
        NavBar navBar = new NavBar(getDriver());
        homePage.open();
        LogInModal logInModal = navBar.login();
        String[] credentials = FileUtils.readFileToString(new File("src/test/resources/credentials.txt"),
                "UTF-8").split("\\|");
        logInModal.login(credentials[0], credentials[1]);
        Assert.assertEquals(navBar.getWelcomeMsg().getText(), "Welcome " + credentials[0]);
    }

    @Test(description = "Add to cart test")
    @MethodOwner(owner = "FacundoPanichelli")
    public void testAddToCart(){
        HomePage homePage = new HomePage(getDriver());
        NavBar navBar = new NavBar(getDriver());
        homePage.open();
        homePage.ssg6();
        ProductPage productPage = new ProductPage(getDriver());
        productPage.addToCart();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        navBar.home();
        homePage.iphone6();
        productPage.addToCart();
        alert.accept();
        navBar.cart();
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertEquals(cartPage.getTotalPrice().getText(), "1150");
    }

    @Test(description = "Make a purchase test")
    @MethodOwner(owner = "FacundoPanichelli")
    public void testPurchase() throws IOException {
        HomePage homePage = new HomePage(getDriver());
        NavBar navBar = new NavBar(getDriver());
        homePage.open();
        CartPage cartPage = navBar.cart();
        cartPage.placeOrder();
        PlaceOrderModal placeOrderModal = new PlaceOrderModal(getDriver());
        String[] orderdata = FileUtils.readFileToString(new File("src/test/resources/orderdata.txt"),
                "UTF-8").split("\\|");
        placeOrderModal.placeOrder(orderdata[0], orderdata[1], orderdata[2], orderdata[3], orderdata[4], orderdata[5]);
        PurchaseConfirmationModal purchaseConfirmation = new PurchaseConfirmationModal(getDriver());
        Assert.assertTrue(purchaseConfirmation.getConfirmationMsg().isElementPresent());
        purchaseConfirmation.ok();
    }

    @Test(description = "Log in with unregiestered credentials")
    @MethodOwner(owner = "FacundoPanichelli")
    public void testUnregisteredLogIn(){
        HomePage homePage = new HomePage(getDriver());
        NavBar navBar = new NavBar(getDriver());
        homePage.open();
        LogInModal logInModal = navBar.login();
        logInModal.login("WrongCredential12345", "12345");
        Alert alert = getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(), "User does not exist.");
        alert.accept();
    }
}
