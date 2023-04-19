package configurationExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Config;
import utils.Driver;

public class DriverUtilTest {

    @BeforeClass
    public void testDriver(){
        Driver.getDriver().get(Config.getProperty("urlSmartBear"));
    }
    @Test
    public void testConfig(){
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@ name=\"ctl00$MainContent$username\"]"));
        WebElement passWord = Driver.getDriver().findElement(By.xpath("//input[@ name=\"ctl00$MainContent$password\"]"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@ name=\"ctl00$MainContent$login_button\"]"));

        userName.sendKeys(Config.getProperty("login"));
        passWord.sendKeys(Config.getProperty("pass"));
        loginButton.click();
    }
    @AfterClass
    public void tearDown(){
        Driver.quitDriver();
    }
}
