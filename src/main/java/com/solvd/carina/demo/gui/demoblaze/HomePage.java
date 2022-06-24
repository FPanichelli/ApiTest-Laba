package com.solvd.carina.demo.gui.demoblaze;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[@href='prod.html?idp_=1' and @class='hrefch']")
    private ExtendedWebElement productSSG6;

    @FindBy(xpath = "//a[@href='prod.html?idp_=5' and @class='hrefch']")
    private ExtendedWebElement productIPhone6;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public ProductPage ssg6(){
        productSSG6.click();
        return new ProductPage(driver);
    }

    public ProductPage iphone6(){
        productIPhone6.click();
        return new ProductPage(driver);
    }

}
