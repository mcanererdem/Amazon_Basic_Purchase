package driver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import util.ElementStore;

public class Driver {

    public static WebDriver webDriver;

    @BeforeSuite
    public void initializeDriver(){
        webDriver = DriverFactory.getDriver();
        webDriver.manage().window().maximize();
    }

    @AfterSuite
    public void closeDriver(){
        webDriver.quit();
    }

}
