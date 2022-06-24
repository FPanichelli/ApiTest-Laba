package com.solvd.carina.demo.gui.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInModal extends AbstractPage {

    @FindBy(id = "loginusername")
    private ExtendedWebElement userName;

    @FindBy (id = "loginpassword")
    private ExtendedWebElement password;

    @FindBy (xpath = "//button[contains(., 'Log in')]")
    private ExtendedWebElement loginBtn;

    public LogInModal(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String userString, String passwordString) {
        userName.type(userString);
        password.type(passwordString);
        loginBtn.click();
        return new HomePage(driver);
    }
}
