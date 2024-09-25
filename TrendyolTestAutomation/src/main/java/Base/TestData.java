package Base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestData {
    public String email;
    public String password;
    public String wrongPassword;
    public String loginUrl;

    public TestData(){
        Properties prop = new Properties();

        try {
            InputStream fileInput = getClass().getClassLoader().getResourceAsStream("config.properties");
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        email = prop.getProperty("EMAIL");
        password = prop.getProperty("PASSWORD");
        wrongPassword = prop.getProperty("WRONGPASSWORD");
        loginUrl = "https://www.trendyol.com/giris";
    }
}
