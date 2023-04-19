package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Driver;

public class AmazonEx {

    @BeforeClass
    public void setUp(){
        Driver.getDriver().get("https://www.etsy.com/");
    }

    @Test
    public void testAmazonWindows(){
        String mainWindow = Driver.getDriver().getWindowHandle();
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Etsy";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        WebElement amazonChoice_1 = Driver.getDriver().findElement(By.xpath("(//h3)[1]"));
        String amazonChoice_1text = amazonChoice_1.getText();
        amazonChoice_1.click();

        for(String window: Driver.getDriver().getWindowHandles()){
            if(!window.equals(mainWindow)){
                Driver.getDriver().switchTo().window(window);
            }
        }
        String amazonChoice_1newPageTxt = Driver.getDriver().findElement(By.
                xpath("//h1[@class=\"wt-text-body-01 wt-line-height-tight wt-break-word wt-mt-xs-1\"]")).getText();
        Assert.assertEquals(amazonChoice_1text,amazonChoice_1newPageTxt,"Text of Amazon Choice is correct");

        Driver.getDriver().switchTo().window(mainWindow);





    }
}
