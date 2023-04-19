package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Driver;

public class MultiWindowsHandle1 {

    @BeforeClass
    public void setUp(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void windowsHandle(){
        String mainWindow = Driver.getDriver().getWindowHandle();
        System.out.println(mainWindow);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "The Internet";

        Assert.assertEquals(actualTitle,expectedTitle,"The title is incorrect");

        WebElement clickHereBtn = Driver.getDriver().findElement(By.xpath("//a[.='Click Here']"));
        clickHereBtn.click();
        //System.out.println(Driver.getDriver().getTitle());

        for(String window: Driver.getDriver().getWindowHandles()){
            if(!window.equals(mainWindow)){
                Driver.getDriver().switchTo().window(window);
            }
        }

        Assert.assertEquals(Driver.getDriver().getTitle(),"New Window");
        Driver.getDriver().switchTo().window(mainWindow);
    }
}
