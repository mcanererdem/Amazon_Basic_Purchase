package util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ElementHelper {

    private final WebDriver driver;
    private final WebDriverWait waiter;
    public Actions action;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.action = new Actions(driver);
    }

    public WebElement presenceElement(By key) {

        return waiter.until(ExpectedConditions.presenceOfElementLocated(key));
    }
    public WebElement clickableElement(By key) {
        return waiter.until(ExpectedConditions.elementToBeClickable(key));
    }

    public WebElement findElement(By key) {
        WebElement element = presenceElement(key);
        return element.findElement(key);
    }

    public void click(By key) {
        WebElement element = clickableElement(key);
        element.click();
    }

    public void clickAndHold(By key) {
        action.clickAndHold(findElement(key)).perform();
    }

    public void hoverOver(By key) {
        action.moveToElement(findElement(key)).perform();
    }

    public void sendKeys(By key, String text) {
        this.findElement(key).sendKeys(text);
    }

    public void clickAndSendKeys(By key, String text) {
        this.findElement(key).click();
        this.findElement(key).sendKeys(text);
    }

    public void scrollDown(int length) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + length + ")", "");
    }

    public void scrollUp(int length) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-" + length + ")", "");
    }

    public boolean assertText(By key, String text) {
        String elementText = this.findElement(key).getText();
        return elementText.equals(text);
    }

    public boolean containText(By key, String text) {
        String elementText = this.findElement(key).getText();
        return elementText.contains(text);
    }

    public void selectCheckBox(By key) {
        if (!this.findElement(key).isSelected()) {
            this.findElement(key).click();
        }
    }

    public List<WebElement> findElements(By keys) {
        return this.driver.findElements(keys);
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        if (dirContents != null) {
            for (File dirContent : dirContents) {
                if (dirContent.getName().equals(fileName)) {
                    // File has been found, it can now be deleted:
                    dirContent.delete();
                    return true;
                }
            }
        }
        return false;
    }

    public void sendKeys(By searchElement, Keys keys) {
        WebElement element = findElement(searchElement);
        element.sendKeys(keys);
    }
}