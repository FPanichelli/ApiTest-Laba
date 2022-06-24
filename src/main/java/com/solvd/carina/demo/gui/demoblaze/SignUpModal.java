package com.solvd.carina.demo.gui.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpModal extends AbstractPage {

    @FindBy (id = "sign-username")
    private ExtendedWebElement userName;

    @FindBy (id = "sign-password")
    private ExtendedWebElement password;

    @FindBy (xpath = "//button[contains(., 'Sign up')]")
    private ExtendedWebElement registerBtn;

    public SignUpModal(WebDriver driver) {
        super(driver);
    }

    public HomePage register(String userString, String passwordString) {
        userName.type(userString);
        password.type(passwordString);
        registerBtn.click();
        return new HomePage(driver);

    }


}
