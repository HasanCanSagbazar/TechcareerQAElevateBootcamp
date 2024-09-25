package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {

    private String accoutnValue;
    public MainPage getAccountName(){
        accoutnValue = chromeDriver.findElement(By.cssSelector("[class='link account-user'] p")).getText();
        return this;
    }
    public String getAccountValue() {
        return accoutnValue;
    }

}
