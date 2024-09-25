package Pages;

import Base.BaseTest;
import Base.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {
    WebElement element;
    public LoginPage fillMail(String email){

        element = chromeDriver.findElement(By.id("login-email"));
        element.clear();
        element.sendKeys(email);
        return this;
    }

    public LoginPage fillPassword(String password){
        element = chromeDriver.findElement(By.name("login-password"));
        element.clear();
        element.sendKeys(password);
        return this;
    }

    public LoginPage clickLogin(){
        element = chromeDriver.findElement(By.cssSelector("button[type='submit']"));
        element.click();
        return this;
    }

    public String getErrorMessage(){
        element = chromeDriver.findElement(By.cssSelector("[class='message']"));
        String value = element.getText();
        return value;
    }

}
