package com.solvd.carina.demo.gui.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderModal extends AbstractPage {

    @FindBy(xpath = "//input[@class='form-control' and @id='name']")
    private ExtendedWebElement orderName;

    @FindBy(xpath = "//input[@class='form-control' and @id='country']")
    private ExtendedWebElement orderCountry;

    @FindBy(xpath = "//input[@class='form-control' and @id='city']")
    private ExtendedWebElement orderCity;

    @FindBy(xpath = "//input[@class='form-control' and @id='card']")
    private ExtendedWebElement orderCard;

    @FindBy(xpath = "//input[@class='form-control' and @id='month']")
    private ExtendedWebElement orderMonth;

    @FindBy(xpath = "//input[@class='form-control' and @id='year']")
    private ExtendedWebElement orderYear;

    @FindBy(xpath = "//button[contains(., 'Purchase')]")
    private ExtendedWebElement purchaseBtn;

    public PlaceOrderModal(WebDriver driver) {
        super(driver);
    }

    public PurchaseConfirmationModal placeOrder(String nameString, String countryString, String cityString, String cardString, String monthString, String yearString){
        orderName.type(nameString);
        orderCountry.type(countryString);
        orderCity.type(cityString);
        orderCard.type(cardString);
        orderMonth.type(monthString);
        orderYear.type(yearString);
        purchaseBtn.click();
        return new PurchaseConfirmationModal(driver);
    }
}
