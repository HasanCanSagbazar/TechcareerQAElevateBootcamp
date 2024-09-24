package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App
{
    public static void main( String[] args )
    {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.trendyol.com/giris");
        chromeDriver.findElement(By.id("login-email")).sendKeys("canhasan870@gmail.com");
        chromeDriver.findElement(By.name("login-password")).sendKeys("Ia9b5C3!D2F");
        chromeDriver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
