package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {

    private String accoutnValue;

    @Step("Get Account Name")
    public MainPage getAccountName(){
        accoutnValue = chromeDriver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        return this;
    }

    @Step("Get Account Name Value")
    public String getAccountValue() {
        return accoutnValue;
    }

}
