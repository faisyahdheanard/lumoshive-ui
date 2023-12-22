package steps;

import config.base;
import data.cartData;
import io.cucumber.java.en.And;
import pages.cartPage;

public class cartStep extends base {
    cartPage CartPage = new cartPage(driver);

    @And("Input {string} for the amount of the price on price field")
    public void inputForTheAmountOfThePriceOnPriceField(String price) throws Exception {
        Thread.sleep(750);
        CartPage.validateCartDetails();
        CartPage.inputPriceField(price);
        CartPage.validateTotalPrice();
    }

    @And("Input the Name field")
    public void inputTheNameField() throws Exception {
        Thread.sleep(750);
        CartPage.setInputName(cartData.DATA_NAME);
    }

    @And("Input the Email field")
    public void inputTheEmailField() throws Exception {
        Thread.sleep(750);
        CartPage.setInputEmail(cartData.DATA_EMAIL);
    }

    @And("Input the Phone no field")
    public void inputThePhoneNoField() throws Exception {
        Thread.sleep(750);
        CartPage.setInputPhoneNo(cartData.DATA_PHONENO);
    }

    @And("Click the CHECKOUT button")
    public void clickTheCHECKOUTButton() throws Exception {
        Thread.sleep(750);
        CartPage.clickCheckoutButton();
    }

    @And("Input the City field")
    public void inputTheCityField() throws Exception {
        Thread.sleep(750);
        CartPage.setInputCity(cartData.DATA_CITY);
    }

    @And("Input the Address field")
    public void inputTheAddressField() throws Exception {
        Thread.sleep(750);
        CartPage.setInputAddress(cartData.DATA_ADDRESS);
    }

    @And("Input the Postal code field")
    public void inputThePostalCodeField() throws Exception {
        Thread.sleep(750);
        CartPage.setInputPostalCode(cartData.DATA_POSTALCODE);
    }
}
