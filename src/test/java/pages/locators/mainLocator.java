package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mainLocator {
    @FindBy(css = ".title")
    public WebElement title_main;

    @FindBy(css = "a[class='btn buy']")
    public WebElement button_buy_now;

    @FindBy(css = "[class=\"trans-status trans-error\"]")
    public WebElement text_failed_purchase;

    @FindBy(css = ".trans-success")
    public WebElement text_success_purchase;


}
