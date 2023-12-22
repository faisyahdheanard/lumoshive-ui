package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cartLocator {
    @FindBy(xpath = "//span[contains(text(), 'Shopping Cart')]")
    public WebElement title_cart;



    //DETAIL FORM
    @FindBy(css = "input[class='text-right']")
    public WebElement text_product_price;

    @FindBy(css = "td[class='amount']")
    public WebElement text_product_total;

    @FindBy(xpath = "//tr[1]/td[2]/input")
    public WebElement field_name;

    @FindBy(xpath = "//tr[2]/td[2]/input")
    public WebElement field_email;

    @FindBy(xpath = "//tr[3]/td[2]/input")
    public WebElement field_phone_no;

    @FindBy(xpath = "//tr[4]/td[2]/input")
    public WebElement field_city;

    @FindBy(xpath = "//tr[5]/td[2]/textarea")
    public WebElement field_address;

    @FindBy(xpath = "//tr[6]/td[2]/input")
    public WebElement field_postal_code;



    @FindBy(css = ".cart-checkout")
    public WebElement button_checkout;

}
