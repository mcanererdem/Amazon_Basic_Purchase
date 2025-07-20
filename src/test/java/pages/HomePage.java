package pages;

import com.thoughtworks.gauge.Gauge;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;
import util.ElementStore;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePage {
    private WebDriver driver;
    private ElementHelper helper;
    private WebDriverWait waiter;

    public HomePage() {
        driver = Driver.webDriver;
        helper = new ElementHelper(driver);
        try {
            Duration timeoutDuration = Duration.ofSeconds(Long.parseLong(System.getenv("DEFAULT_TIMEOUT")));
            waiter = new WebDriverWait(driver, timeoutDuration);

        } catch (Exception e) {
            Gauge.writeMessage(e.getMessage());
        }
    }

    public void anasayfayaGit() {
        String app_url = System.getenv("APP_URL");
        driver.get(app_url);
        waiter.until(ExpectedConditions.titleContains("Hepsiburada"));
        assertThat(Driver.webDriver.getTitle()).contains("Hepsiburada");
    }

    public void elementeTikla(String key) {
        By element = ElementStore.getBy(key);
        helper.click(element);
    }

    public void aramaAlaninaDegerGir(String key, String text) {
        By searchElement = ElementStore.getBy(key);
        try {
            Thread.currentThread().sleep(1000);
            helper.sendKeys(searchElement, text);
            helper.sendKeys(searchElement, Keys.ENTER);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void elementTextDogrula(String key, String text) {

    }
}
