package configurationExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.Config;

public class ConfigTest {

    @Test
    public void testConfig(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(Config.getProperty("urlSmartBear"));
        WebElement userName = driver.findElement(By.xpath("//input[@ name=\"ctl00$MainContent$username\"]"));
        userName.sendKeys(Config.getProperty("login"));
        WebElement passWord = driver.findElement(By.xpath("//input[@ name=\"ctl00$MainContent$password\"]"));
        passWord.sendKeys(Config.getProperty("pass"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@ name=\"ctl00$MainContent$login_button\"]"));
        loginButton.click();

    }

}
