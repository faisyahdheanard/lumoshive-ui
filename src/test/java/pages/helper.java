package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebElement;

public class helper {
    public static void sendText(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public static String generateRandomEmail() {
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(8);
        email = temp + "@gmail.com";
        return email;
    }

    public static String generateRandomNumeric(int count) {
        String num = RandomStringUtils.randomNumeric(count);
        return num;
    }
}
