package Pages;

import Base.BaseTest;
import Base.TestData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {
    WebElement element;

    @Step("Fill mail address")
    public LoginPage fillMail(String email){

        element = chromeDriver.findElement(By.id("login-email"));
        element.clear();
        element.sendKeys(email);
        screenshot();
        return this;
    }

    @Step("Fill user password")
    public LoginPage fillPassword(String password){
        element = chromeDriver.findElement(By.name("login-password"));
        element.clear();
        element.sendKeys(password);
        return this;
    }

    @Step("Click login button")
    public LoginPage clickLogin(){
        element = chromeDriver.findElement(By.cssSelector("button[type='submit']"));
        element.click();
        return this;
    }

    @Step("Get error message")
    public String getErrorMessage(){
        element = chromeDriver.findElement(By.cssSelector("[class='message']"));
        String value = element.getText();
        screenshot();
        return value;
    }

}
