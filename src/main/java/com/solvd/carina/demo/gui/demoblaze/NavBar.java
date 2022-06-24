package com.solvd.carina.demo.gui.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavBar extends AbstractUIObject {

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[1]/a")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[2]/a")
    private ExtendedWebElement contactBtn;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[3]/a")
    private ExtendedWebElement aboutUsBtn;

    @FindBy(xpath = "//*[@id=\"cartur\"]")
    private ExtendedWebElement cartLink;

    @FindBy(xpath = "//*[@id=\"login2\"]")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"signin2\"]")
    private ExtendedWebElement signUpBtn;

    @FindBy(id = "nameofuser")
    private ExtendedWebElement welcomeMsg;


    public NavBar(WebDriver driver) {
        super(driver);
    }

    public HomePage home(){
        homeLink.click();
        return new HomePage(driver);
    }

    public CartPage cart(){
        cartLink.click();
        return new CartPage(driver);
    }

    public SignUpModal signUp(){
        signUpBtn.click();
        return new SignUpModal(driver);
    }

    public LogInModal login(){
        loginBtn.click();
        return new LogInModal(driver);
    }

    public ExtendedWebElement getWelcomeMsg() {
        return welcomeMsg;
    }
}
