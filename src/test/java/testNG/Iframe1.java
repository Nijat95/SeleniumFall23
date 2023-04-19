package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Config;
import utils.Driver;

public class Iframe1 {
    //1 Create a new class called IframePractice
    //2Create new tests and create setUps
    //3 Go to https://the-internet.herokuapp.com/iframe
    //4 Assert : "You content goes here " Text is displayed"
    //5 Assert: "An iFrame containing the TinyMCE WYSIWYG Editor"

    @BeforeClass
    public void setUp(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/tinymce");
    }

    @Test
    public void iframePractice(){
//        WebElement iframe = Driver.getDriver().findElement(By.cssSelector("#mce_0_ifr"));
        //Driver.getDriver().switchTo().frame(0);
        Driver.getDriver().switchTo().frame("mce_0_ifr");
//        Driver.getDriver().switchTo().frame(iframe);

        WebElement paragraph = Driver.getDriver().findElement(By.xpath("//body[.=\"Your content goes here.\"]"));
        Assert.assertTrue(paragraph.isDisplayed());
        Driver.getDriver().switchTo().parentFrame();

        WebElement headerText = Driver.getDriver().findElement(By.xpath("//h3"));
        Assert.assertTrue(headerText.isDisplayed());
    }
}
