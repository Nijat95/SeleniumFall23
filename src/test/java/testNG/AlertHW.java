package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertHW {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
    }
    @Test
    public void javaScriptAlert(){
        WebElement jsAlert = driver.findElement(By.xpath("//span[@ id=\"button1\"]"));
        jsAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @Test
    public void modalPopup(){
        WebElement jsAlert = driver.findElement(By.xpath("//span[@ id=\"button2\"]"));
        jsAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    @Test
    public void javaScriptConfirmBox(){
        WebElement jsAlert = driver.findElement(By.xpath("//span[@ id=\"button4\"]"));
        jsAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        String expectedValue = "You pressed Cancel!";
        WebElement result = driver.findElement(By.xpath("//p[@id=\"confirm-alert-text\"]"));
        Assert.assertEquals(result.getText(), expectedValue);
    }
}

