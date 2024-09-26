package Base;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import static Base.BaseTest.chromeDriver;

public class BaseLibrary extends TestData {

    @Step("wait {time} miliseconds")
    public void Sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Compare values")
    public void AssetEquals(String expectedValue, String actualValue){
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.BYTES);
    }
}
