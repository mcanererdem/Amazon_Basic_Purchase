package pages;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected ElementHelper helper;
    protected WebDriverWait waiter;

    protected BasePage() {
        driver = Driver.webDriver;
        helper = new ElementHelper(driver);
        Duration timeoutDuration = Duration.ofSeconds(Long.parseLong(System.getenv("DEFAULT_TIMEOUT")));
        waiter = new WebDriverWait(driver, timeoutDuration);
    }
}
