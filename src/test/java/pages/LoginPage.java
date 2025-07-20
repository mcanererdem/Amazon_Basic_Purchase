package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.ElementStore;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends BasePage {
    public LoginPage() {
        super();
    }

    public void enterEmail(String key, String email) {
        By element = ElementStore.getBy(key);
        waiter.until(ExpectedConditions.elementToBeClickable(element));
        helper.clickAndSendKeys(element, email);
    }
}
