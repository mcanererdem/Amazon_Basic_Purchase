package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.ElementStore;

import java.util.Date;

import static com.thoughtworks.gauge.Gauge.writeMessage;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends BasePage {
    public LoginPage() {
        super();
    }

    public void enterCredentials(String key, String email) {
        By element = ElementStore.getBy(key);
        waiter.until(ExpectedConditions.elementToBeClickable(element));
        helper.clickAndSendKeys(element, email);
    }

    public void signInToSystem(String key) {
        By element = ElementStore.getBy(key);
        waiter.until(ExpectedConditions.elementToBeClickable(element));
        helper.click(element);
    }

    public void signInToSystemHandleException(String key, String expKey) {
        By element = ElementStore.getBy(key);
        waiter.until(ExpectedConditions.elementToBeClickable(element));
        helper.click(element);

        try {
            Thread.sleep(2 * 1000);

            By expElement = ElementStore.getBy(expKey);
            waiter.until(ExpectedConditions.presenceOfElementLocated(expElement));
            String expText = helper.findElement(expElement).getText();
            System.out.println("******************* -> " + expText);

            if (expText.contains("N1E2")) {
                System.out.println("******************* -> " + expText);

                String cookieName = "userInfo"; // <--- BURAYA KOPYALADIĞINIZ ÇEREZ ADINI YAZIN
                String cookieValue = "%7B%22uid%22%3A%22a03ae747-64d6-4ed0-abd8-87e47e107b8d%22%2C%22t%22%3A%22%C4%B0llaki%20TACAB%22%2C%22fn%22%3A%22%C4%B0llaki%22%2C%22ln%22%3A%22TACAB%22%2C%22e%22%3A%22t%2A%2A%2A%2A%2A%2A%2Ai%40gmail.com%22%2C%22ak%22%3A%22af7f2a37-cc4b-4f1c-87fd-ff3642f67ecb%22%2C%22p%22%3A%7B%22t%22%3A%5B%5D%2C%22e%22%3A%22mSAiqMqyZWJHCr3BFc25%2Fiv9eloxDN5JXQnsPhXAPPY%3D%22%7D%2C%22g%22%3A%22%22%2C%22exp%22%3A1753346791%2C%22rm%22%3Afalse%7D"; // <--- BURAYA KOPYALADIĞINIZ ÇEREZ DEĞERİNİ YAPIŞTIRIN
                String domain = ".hepsiburada.com"; // Hepsiburada için genellikle .hepsiburada.com
                String path = "/"; // Çoğu zaman /
                boolean isSecure = true; // HTTPS kullandığı için evet, true

                Cookie authCookie = new Cookie.Builder(cookieName, cookieValue)
                        .domain(domain)
                        .path(path)
                        .isSecure(isSecure)
                        .expiresOn(new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 7))) // İsteğe bağlı: Çereze bir son kullanma tarihi verebilirsiniz (örn. 7 gün)
                        .build();

                driver.manage().addCookie(authCookie);
                writeMessage("Manuel kimlik doğrulama çerezi eklendi: " + cookieName);

                Thread.sleep(1000);

                driver.navigate().refresh();
                writeMessage("Sayfa çerez ile yeniden yüklendi.");

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.signInToSystem(key);
    }
}
