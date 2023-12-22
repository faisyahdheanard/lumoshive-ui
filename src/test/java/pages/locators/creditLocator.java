package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class creditLocator {
    @FindBy(css = "[id=\"snap-midtrans\"]")
    public WebElement iframe_payment;

    @FindBy(xpath = "//div[4]/a/div[1]/div[1]")
    public WebElement button_credit_option;



    //CREDIT FORM
    @FindBy(xpath = "//div[1]/div[2]/div[2]/input")
    public WebElement field_card_number;

    @FindBy(css = "#card-expiry")
    public WebElement field_exp_date;

    @FindBy(css = "#card-cvv")
    public WebElement field_cvv;

    @FindBy(css = "[class=\"card-pay-button-part credit-card\"]")
    public WebElement button_pay_now;

    @FindBy(css = "[for=\"690\"]")
    public WebElement radio_button_promo_flashsale;

    @FindBy(css = "[for=\"628\"]")
    public WebElement radio_button_promo_testing;

    @FindBy(css = "[for=\"no-promo\"]")
    public WebElement radio_button_with_no_promo;

    @FindBy(css = ".promo-amount")
    public WebElement text_promo_amount;

    @FindBy(css = ".header-amount")
    public WebElement text_total_amount;



    //ISSUING BANK
    @FindBy(css = "[title=\"3ds-iframe\"]")
    public WebElement iframe_issue;

    @FindBy(xpath = "//div/div/h1")
    public WebElement text_issuing_bank;

    @FindBy(css = "#otp")
    public WebElement field_otp;

    @FindBy(css = ".btn-success")
    public WebElement button_ok;



    //SUCCESS INFO
    @FindBy(css = ".checkmark")
    public WebElement text_payment_success;



    //FAILED INFO
    @FindBy(css = ".cancel-modal-title")
    public WebElement text_payment_failed;

    @FindBy(css = "[class=\"btn full primary\"]")
    public WebElement button_back;













}
