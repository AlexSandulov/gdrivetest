package org.test.basePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    protected static void preInit() {
        try (InputStream input = new FileInputStream("src/main/resources/test.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            System.setProperty("webdriver.chrome.driver", prop.getProperty("webdriver.chrome.driver"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @BeforeClass
    protected void init() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--start-maximized", "--disable-popup-blocking");
        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS); //implicit

    }

//    @BeforeMethod
//    protected void logIntoApp(){
//        openPage("https://login.tst-us-east.medispend.com/dashboard/login");
//        LoginPagePO loginPagePO = new LoginPagePO(driver);
//        loginPagePO.loginUser("admin@alpha.com", "password1")
//                .waitDashboardIsShown();
//    }

    @AfterClass
    protected void tearDown() {
        driver.close();
    }

    public void openPage(String url) {
        driver.navigate().to(url);
    }

}
