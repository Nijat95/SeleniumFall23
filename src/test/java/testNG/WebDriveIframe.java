package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriveIframe {
   /* 1.Navigate to https://webdriveruniversity.com/IFrame/index.html
            2.Assert that GREAT SERVICE! text is displayed
3.Assert that header WebdriverUniversity.com (IFrame) on the top is displayed
    WebDriver | IFrame*/
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/IFrame/index.html");
    }
    @Test
    public void iFramePractice(){
        driver.switchTo().frame("frame");
        WebElement greatService = driver.findElement(By.xpath("//p[.=\"GREAT SERVICE!\"]"));
        Assert.assertTrue(greatService.isDisplayed());
        driver.switchTo().defaultContent();

        WebElement headerText = driver.findElement(By.xpath("//a[@id=\"nav-title\"]"));
        System.out.println(headerText.getText());
    }
}
