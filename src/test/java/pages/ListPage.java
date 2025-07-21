package pages;

import com.thoughtworks.gauge.ExecutionContext;
import com.thoughtworks.gauge.Gauge;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.ElementStore;

import static org.assertj.core.api.Assertions.assertThat;

public class ListPage extends BasePage {
    public static String secilenUrunTitle = "";

    public ListPage() {
        super();
    }

    public void elementTextDogrula(String key, String expText) {
        By element = ElementStore.getBy(key);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(element));
        String accText = helper.findElement(element).getText();
        assertThat(accText).contains(expText);
    }


    public void urunSecVeTikla(String key) {
        By element = ElementStore.getBy(key);
        waiter.until(ExpectedConditions.elementToBeClickable(element));
        secilenUrunTitle = helper.findElement(element).getText();
        helper.click(element);
    }
}
