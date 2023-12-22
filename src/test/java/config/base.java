package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.utilSetting;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class base {
    protected static WebDriver driver;

    protected void getDriver() {
        String browserName = System.getenv("browserName");

        if (browserName == null) {
            browserName = "CHROME";
        }

        if (Objects.equals(browserName,"CHROME")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else if (Objects.equals(browserName,"FIREFOX")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");

            driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Invalid browser choice: ");
        }

        driver.manage().timeouts().pageLoadTimeout(utilSetting.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(utilSetting.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }
    protected static void quitDriver() {
        driver.quit();
    }
}
