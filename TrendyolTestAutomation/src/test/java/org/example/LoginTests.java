package org.example;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import io.qameta.allure.Feature;
import org.testng.annotations.*;

@Feature("Login Test Scenarios")
public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test(description = "Successfully User Login")
    public void LoginSuccessful() throws InterruptedException {
        loginPage.fillMail(email)
                .fillPassword(password)
                .clickLogin()
                .Sleep(3000);

        String accountValue = mainPage.getAccountName().getAccountValue();
        AssetEquals("Hesabım", accountValue);
    }

    @Test(description = "Unsuccessfully User Login")
    public void LoginUnsuccessfulPassword() throws InterruptedException {
        loginPage.fillMail(email)
                .fillPassword(wrongPassword)
                .clickLogin()
                .Sleep(3000);

        String value = loginPage.getErrorMessage();
        AssetEquals("E-posta adresiniz ve/veya şifreniz hatalı.", value);
    }

    @Test(description = "Empty Email Field Control")
    public void RequiredEmailControl() throws InterruptedException {
        loginPage.fillPassword(password)
                .clickLogin()
                .Sleep(3000);

        String value = loginPage.getErrorMessage();
        AssetEquals("Lütfen geçerli bir e-posta adresi giriniz.", value);
    }

    @Test(description = "Empty Password Field Control")
    public void RequiredPasswordControl() throws InterruptedException {
        loginPage.fillMail(email)
                .clickLogin()
                .Sleep(3000);

        String value = loginPage.getErrorMessage();
        AssetEquals("Lütfen şifrenizi giriniz.", value);
    }

    @Test(description = "Min Max Character Control")
    public void MinMaxCharacterControl() throws InterruptedException {
        String value;
        loginPage.fillMail("a")
                .fillPassword("abc")
                .clickLogin()
                .Sleep(3000);
        value = loginPage.getErrorMessage();
        AssetEquals("Lütfen geçerli bir e-posta adresi giriniz.", value);

        loginPage.fillMail(email)
                .clickLogin()
                .Sleep(3000);
        value = loginPage.getErrorMessage();
        AssetEquals("E-posta adresiniz ve/veya şifreniz hatalı.", value);

        loginPage.fillMail(email)
                .fillPassword(password)
                .clickLogin()
                .Sleep(3000);

        String accountValue = mainPage.getAccountName().getAccountValue();
        AssetEquals("Hesabım", accountValue);
    }
}
