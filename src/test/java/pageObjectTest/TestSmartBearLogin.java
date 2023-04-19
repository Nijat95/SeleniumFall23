package pageObjectTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjectModel.SmartBearLogin;
import utils.Config;
import utils.Driver;

public class TestSmartBearLogin {
    @BeforeClass
    public void setUp(){
        Driver.getDriver().get(Config.getProperty("urlSmartBear"));
    }
    @Test
    public void LoginSmartBear() {
        SmartBearLogin smartBear = new SmartBearLogin(Driver.getDriver());
        smartBear.loginSmartBear(Config.getProperty("login"));
        smartBear.enterPassword(Config.getProperty("pass"));
        smartBear.ClickSubmitBtn();

    }
   @AfterTest
    public void TearDown() {
        Driver.quitDriver();
   }



}
