package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest extends BaseLibrary{
    public static WebDriver chromeDriver;

    @BeforeMethod
    public void OpenBrowser(){
        chromeDriver = new ChromeDriver();
        chromeDriver.get(loginUrl);
        chromeDriver.manage().window().maximize();
    }

    @AfterMethod
    public void afterTest() throws InterruptedException {
        Thread.sleep(1000);
        chromeDriver.quit();
    }
}
