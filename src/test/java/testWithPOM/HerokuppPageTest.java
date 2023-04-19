package testWithPOM;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HerokuppPage;
import utils.Driver;

public class HerokuppPageTest {

    HerokuppPage herokuppPage = new HerokuppPage();
    @BeforeClass
    public void setup(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/hovers");
    }

    @Test
    public void hovers(){
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(herokuppPage.avatar1).perform();
        Assert.assertTrue(herokuppPage.user1text.isDisplayed());

        actions.moveToElement(herokuppPage.avatar2).perform();
        Assert.assertTrue(herokuppPage.user2text.isDisplayed());

        actions.moveToElement(herokuppPage.avatar3).perform();
        Assert.assertTrue(herokuppPage.user3text.isDisplayed());
    }

    @AfterClass
    public void tearDown(){
        Driver.quitDriver();
    }
}
