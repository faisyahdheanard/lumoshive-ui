package steps;

import config.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.tools.jmod.Main;
import pages.mainPage;

public class mainStep extends base {

    mainPage MainPage = new mainPage(driver);

    @Given("Navigate to the website")
    public void navigateToTheWebsite() {
        getDriver();
        MainPage = new mainPage(driver);
        MainPage.goToTheMainPage();
    }

    @When("Click the BUY NOW button")
    public void clickTheBUYNOWButton() throws Exception {
        Thread.sleep(750);
        MainPage.clickBuyNowButton();
    }

    @And("Be directed back to the Main Page")
    public void beDirectedBackToTheMainPage() throws Exception{
        Thread.sleep(750);
        MainPage.validateOnTheMainPage();
    }

    @And("The success message is displayed")
    public void theSuccessMessageIsDisplayed() throws Exception {
        Thread.sleep(750);
        MainPage.validateSuccessMessageDisplayed();
        quitDriver();
    }

    @And("The message indicating the reason for the failure is displayed")
    public void theMessageIndicatingTheReasonForTheFailureIsDisplayed() throws Exception {
        Thread.sleep(750);
        MainPage.validateFailedMessageDisplayed();
        quitDriver();
    }
}
