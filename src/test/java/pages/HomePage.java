package pages;

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
        int attempts = 0;
        while (attempts < 3) {
            try {
                waiter.until(ExpectedConditions.elementToBeClickable(by));
                driver.findElement(by).click();
                return;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

    public void aramaAlaninaDegerGir(String key, String text) {
        By element = ElementStore.getBy(key);
        try {
            Thread.sleep(500);
            helper.clickAndSendKeys(element, text);
            helper.sendKeys(element, Keys.ENTER);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
