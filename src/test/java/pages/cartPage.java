package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.locators.cartLocator;


import java.time.Duration;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.helper.*;

public class cartPage extends cartLocator {
    WebDriver driver;
    private String amountPrice;


    public cartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void validateCartDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement titleOnCart = wait.until(ExpectedConditions.visibilityOf(title_cart));
        assertTrue(titleOnCart.isDisplayed());
    }

    public void inputPriceField(String price) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement priceField = wait.until(ExpectedConditions.visibilityOf(text_product_price));

        sendText(priceField, price);

        Preferences prefs = Preferences.userRoot().node("test.java");
        prefs.put("amount price", price); }

    public void validateTotalPrice() {
        Preferences prefs = Preferences.userRoot().node("test.java");
        String expectedPrice = prefs.get("amount price", "");

        String actualPrice = text_product_total.getText();

        String cleanedExpectedPrice = expectedPrice.replaceAll("[^0-9]", "");
        String cleanedActualPrice = actualPrice.replaceAll("[^0-9]", "");

        int numericExpectedPrice = Integer.parseInt(cleanedExpectedPrice);
        int numericActualPrice = Integer.parseInt(cleanedActualPrice);

        assertEquals(numericExpectedPrice, numericActualPrice);
    }

    public void setInputName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement nameField = wait.until(ExpectedConditions.visibilityOf(field_name));
        sendText(nameField, name);
    }

    public void setInputEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOf(field_email));
        sendText(emailField, email);
    }

    public void setInputPhoneNo(String phoneNo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement phoneNoField = wait.until(ExpectedConditions.visibilityOf(field_phone_no));
        sendText(phoneNoField, phoneNo);
    }

    public void setInputCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cityField = wait.until(ExpectedConditions.visibilityOf(field_city));
        sendText(cityField, city);
    }

    public void setInputAddress(String address) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addressField = wait.until(ExpectedConditions.visibilityOf(field_address));
        sendText(addressField, address);
    }

    public void setInputPostalCode(String postalCode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement postalCodeField = wait.until(ExpectedConditions.visibilityOf(field_postal_code));
        sendText(postalCodeField, postalCode);
    }

    public void clickCheckoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement checkOutButton = wait.until(ExpectedConditions.visibilityOf(button_checkout));
        checkOutButton.click();
    }





}
