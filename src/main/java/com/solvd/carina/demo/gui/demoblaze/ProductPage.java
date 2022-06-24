package com.solvd.carina.demo.gui.demoblaze;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='btn btn-success btn-lg']")
    private ExtendedWebElement addToCartBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addToCart(){
        addToCartBtn.click();
        return new ProductPage(driver);
    }
}
