package com.solvd.carina.demo.gui.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PurchaseConfirmationModal extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class,'sweet-alert  showSweetAlert visible')]/h2")
    private ExtendedWebElement confirmationMsg;

    @FindBy(xpath = "//button[@Class='confirm btn btn-lg btn-primary']")
    private ExtendedWebElement okBtn;

    public PurchaseConfirmationModal(WebDriver driver) {
        super(driver);
    }

    public HomePage ok(){
        okBtn.click();
        return new HomePage(driver);
    }

    public ExtendedWebElement getConfirmationMsg() {
        return confirmationMsg;
    }
}
