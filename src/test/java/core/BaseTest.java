package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;


public class BaseTest {
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "2600x1900";
        Configuration.headless = false;
    }

    @Before
    public static void init(){
        setUp();
    }

    @After
    public static void tearDown(){
        Selenide.closeWebDriver();
    }

    
}
