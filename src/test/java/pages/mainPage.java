package pages;

import jdk.tools.jmod.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.locators.mainLocator;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class mainPage extends mainLocator {
    WebDriver driver;

    public mainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void goToTheMainPage() {
        driver.get("https://demo.midtrans.com/");
    }

    public void clickBuyNowButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement buyNowButton = wait.until(ExpectedConditions.visibilityOf(button_buy_now));
        buyNowButton.click();
    }

    public void validateOnTheMainPage() {
        driver.switchTo().parentFrame();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement titleOnMain = wait.until(ExpectedConditions.visibilityOf(title_main));
        assertTrue(titleOnMain.isDisplayed());
    }

    public void validateSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement successText = wait.until(ExpectedConditions.visibilityOf(text_success_purchase));
        assertTrue(successText.isDisplayed());
    }

    public void validateFailedMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement failedText = wait.until(ExpectedConditions.visibilityOf(text_failed_purchase));
        assertTrue(failedText.isDisplayed());
    }
}
