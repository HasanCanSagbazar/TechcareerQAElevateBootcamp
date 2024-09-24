package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTests {
    @Test
    public void LoginSuccesful() throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.trendyol.com/giris");
        chromeDriver.manage().window().maximize();
        chromeDriver.findElement(By.id("login-email")).sendKeys("<email>");
        chromeDriver.findElement(By.name("login-password")).sendKeys("<password>");
        chromeDriver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);
        String value = chromeDriver.findElement(By.cssSelector("[class='link account-user'] p")).getText();

        System.out.println(value);

        Thread.sleep(1000);
        chromeDriver.quit();
    }
}
