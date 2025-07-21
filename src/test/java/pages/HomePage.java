package pages;

import com.thoughtworks.gauge.ExecutionContext;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.ElementStore;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePage extends BasePage {
    private final String secilenUrunTitle = "";

    public HomePage() {
        super();
    }

    public void anasayfayaGit() {
        String app_url = System.getenv("APP_URL");
        driver.get(app_url);
        waiter.until(ExpectedConditions.titleContains("Hepsiburada"));
        assertThat(Driver.webDriver.getTitle()).contains("Hepsiburada");
    }

    public void elementeTikla(String key) {
        By by = ElementStore.getBy(key);
        waiter.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();

    }

    public void aramaAlaninaDegerGir(String key, String text) {
        By element = ElementStore.getBy(key);
        try {
            Thread.sleep(1000);
            helper.clickAndSendKeys(element, text);
            helper.sendKeys(element, Keys.ENTER);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
