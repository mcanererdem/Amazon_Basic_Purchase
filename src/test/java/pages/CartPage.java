package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.ElementStore;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage extends BasePage {

    protected CartPage() {
        super();
    }

    public void secilenUrunuDogrula(String key) {
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);

        By element = ElementStore.getBy(key);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(element));
        String accText = helper.findElement(element).getText();
        String expText = ListPage.secilenUrunTitle;
        assertThat(expText).contains(accText);
    }

    public void sepetteUrunuDogrula(String key) {
        By element = ElementStore.getBy(key);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(element));
        String accText = helper.findElement(element).getText();
        String expText = ListPage.secilenUrunTitle;
        assertThat(accText).contains(expText);
    }
}
