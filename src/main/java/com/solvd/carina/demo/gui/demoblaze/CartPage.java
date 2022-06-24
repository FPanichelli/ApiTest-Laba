package com.solvd.carina.demo.gui.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//button[contains(., 'Place Order')]")
    private ExtendedWebElement placeOrderBtn;

    @FindBy(xpath = "//h3[@class='panel-title']")
    private ExtendedWebElement totalPrice;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public PlaceOrderModal placeOrder(){
    placeOrderBtn.click();
    return new PlaceOrderModal(driver);
    }

    public ExtendedWebElement getTotalPrice() {
        return totalPrice;
    }
}
