package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.locators.creditLocator;

import java.time.Duration;
import java.util.prefs.Preferences;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.helper.*;

public class creditPage extends creditLocator {
    WebDriver driver;

    public creditPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void switchToIFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOf(iframe_payment));
        driver.switchTo().frame(iframe);
    }

    public void clickCreditOptionButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement creditOption = wait.until(ExpectedConditions.visibilityOf(button_credit_option));
        creditOption.click();
    }

    public void setInputCardNumber(String cardNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOf(field_card_number));
        cardNumberField.sendKeys(cardNumber);
    }

    public void setInputExpirationDate (String expDate) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement expirationDateField = wait.until(ExpectedConditions.visibilityOf(field_exp_date));
        expirationDateField.sendKeys(expDate);
    }

    public void setInputCVV (String cvv) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cvvField = wait.until(ExpectedConditions.visibilityOf(field_cvv));
        cvvField.sendKeys(cvv);
    }

    public void clickPayNowButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement payNowButton = wait.until(ExpectedConditions.visibilityOf(button_pay_now));
        payNowButton.click();
    }

    public void selectPromoWrap(String promo) {
        WebElement element = null;
        switch(promo) {
            case "Promo Flash Sale":
                element = radio_button_promo_flashsale;
                break;
            case "Promo Testing":
                element = radio_button_promo_testing;
                break;
            case "Proceed without promo":
                element = radio_button_with_no_promo;
                break;
        }
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }


        public void validateTheTotalAmount(String promo) {
        Preferences prefs = Preferences.userRoot().node("test.java");
        String prefsPrice = prefs.get("amount price", "");

        if (promo.equals("Promo Flash Sale") || promo.equals("Promo Testing")) {
            int prefsPriceValue = Integer.parseInt(prefsPrice);
            prefsPriceValue -= 1000;
            prefsPrice = String.valueOf(prefsPriceValue);


            String expectedPrice = text_total_amount.getText();
            String cleanedExpectedPrice = expectedPrice.replaceAll("[^0-9]", "");

            assertEquals(cleanedExpectedPrice, prefsPrice);
        } else if(promo.equals("Proceed without promo")) {
            String expectedPrice = text_total_amount.toString();
            assertEquals(expectedPrice, prefsPrice);
        }
    }

    public void switchToIFrame2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOf(iframe_issue));
        driver.switchTo().frame(iframe);
    }
    public void validateIssuingBankDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement otpField = wait.until(ExpectedConditions.visibilityOf(field_otp));
        assertTrue(otpField.isDisplayed());
    }

    public void setInputOTP(String otp) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement otpField = wait.until(ExpectedConditions.visibilityOf(field_otp));
        otpField.sendKeys(otp);
    }

    public void clickOkButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement okButton = wait.until(ExpectedConditions.visibilityOf(button_ok));
        okButton.click();
    }

    public void validatePaymentMessage(String message) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        switch (message) {
            case "Payment Successful":
                driver.switchTo().parentFrame();
                WebElement paymentSuccess = wait.until(ExpectedConditions.visibilityOf(text_payment_success));
                assertTrue(paymentSuccess.isDisplayed());
                break;

            case "Payment declined by bank":
                driver.switchTo().parentFrame();
                WebElement paymentDecline = wait.until(ExpectedConditions.visibilityOf(text_payment_failed));
                assertTrue(paymentDecline.isDisplayed());
                break;
        }
    }

    public void clickBackButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement backButton = wait.until(ExpectedConditions.visibilityOf(button_back));
        backButton.click();
    }
}
