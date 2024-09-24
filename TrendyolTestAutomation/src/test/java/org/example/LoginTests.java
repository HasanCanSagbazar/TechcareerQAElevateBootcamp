package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginTests {
    WebDriver chromeDriver;
    Properties prop;
    @BeforeMethod
    public void OpenBrowser(){
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.trendyol.com/giris");
        chromeDriver.manage().window().maximize();

        try {
            prop = new Properties();
            InputStream fileInput = getClass().getClassLoader().getResourceAsStream("config.properties");
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void LoginSuccesful() throws InterruptedException {
        String email = prop.getProperty("EMAIL");
        String password = prop.getProperty("PASSWORD");

        chromeDriver.findElement(By.id("login-email")).sendKeys(email);
        chromeDriver.findElement(By.name("login-password")).sendKeys(password);
        chromeDriver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);
        String value = chromeDriver.findElement(By.cssSelector("[class='link account-user'] p")).getText();

        Assert.assertEquals("Hesabım", value);
    }

    @AfterMethod
    public void afterTest() throws InterruptedException {
        Thread.sleep(1000);
        chromeDriver.quit();
    }
}
