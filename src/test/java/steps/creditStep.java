package steps;

import config.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.creditPage;
import data.creditData;

public class creditStep extends base {

    creditPage CreditPage = new creditPage(driver);

    @And("Click the Credit or Debit Card button")
    public void clickTheCreditDebitCardButton() throws InterruptedException {
        Thread.sleep(2000);
        CreditPage = new creditPage(driver);
        CreditPage.switchToIFrame();
        Thread.sleep(750);
        CreditPage.clickCreditOptionButton();
    }

    @And("Input the Card number field with {string} Card number")
    public void inputTheCardNumberFieldWithCardNumber(String type) throws Exception {
        switch (type) {
            case "valid":
                Thread.sleep(750);
                CreditPage.setInputCardNumber(creditData.TRUE_DATA_CARD_NUMBER);
                break;
            case "invalid":
                Thread.sleep(750);
                CreditPage.setInputCardNumber(creditData.FALSE_DATA_CARD_NUMBER);
                break;
        }
    }

    @And("Input the Expiration date field with {string} Expiration date")
    public void inputTheExpirationDateFieldWithExpirationDate(String type) throws Exception {
        switch (type) {
            case "valid":
                Thread.sleep(750);
                CreditPage.setInputExpirationDate(creditData.TRUE_DATA_EXPIRATION_DATE);
                break;
            case "invalid":
                Thread.sleep(750);
                CreditPage.setInputExpirationDate(creditData.FALSE_DATA_EXPIRATION_DATE);
                break;
        }
    }

    @And("Input the CVV field with {string} CVV")
    public void inputTheCVVFieldWithCVV(String type) throws Exception {
        switch (type) {
            case "valid":
                Thread.sleep(750);
                CreditPage.setInputCVV(creditData.TRUE_DATA_CVV);
                break;
            case "invalid":
                Thread.sleep(750);
                CreditPage.setInputCVV(creditData.FALSE_DATA_CVV);
                break;
        }
    }

    @And("Select {string} on the promo option")
    public void selectThePromoOption(String promoName) throws Exception {
        Thread.sleep(2000);
        CreditPage.selectPromoWrap(promoName);

    }

    @Then("Ensure the total amount is {string}")
    public void ensureTheTotalAmountIs(String price) throws Exception {
        Thread.sleep(750);
        CreditPage.validateTheTotalAmount(price);
    }

    @When("Click the Pay Now button")
    public void clickThePayNowButton() throws Exception {
        Thread.sleep(750);
        CreditPage.clickPayNowButton();
    }

    @Then("The info about the Issuing Bank is displayed")
    public void theInfoAboutTheIssuingBankIsDisplayed() throws Exception {
        Thread.sleep(2000);
        CreditPage.switchToIFrame2();
        Thread.sleep(750);
        CreditPage.validateIssuingBankDisplayed();
    }

    @When("Input the Password field")
    public void inputThePasswordField() throws Exception {
        Thread.sleep(750);
        CreditPage.setInputOTP(creditData.DATA_OTP);
    }

    @And("Click the OK button")
    public void clickTheOKButton() throws Exception {
        Thread.sleep(750);
        CreditPage.clickOkButton();
    }

    @Then("The message saying {string} is displayed")
    public void theMessageSayingIsDisplayed(String message) throws Exception {
        Thread.sleep(750);
        CreditPage.validatePaymentMessage(message);
    }

    @When("Click the Back button")
    public void clickTheBackButton() throws Exception {
        Thread.sleep(750);
        CreditPage.clickBackButton();
    }

}
