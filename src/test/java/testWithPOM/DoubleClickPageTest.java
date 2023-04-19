package testWithPOM;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DoubleClickPage;
import utils.Driver;

import javax.swing.*;

public class DoubleClickPageTest {

    //DoubleClickTest
    // 1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    // 2. Switch to iframe.
    // 3. Double-click on the text “Double-click me to change my text color.”
    // 4. Assert: Text’s “style” attribute value contains “red”.
    DoubleClickPage doubleClickPage = new DoubleClickPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void testDoubleClick(){
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().switchTo().frame(doubleClickPage.iFrame);
        actions.doubleClick(doubleClickPage.colorText).perform();
        //actions.doubleClick(doubleClickPage.colorText).build().perform(); 2nd Way to Double-Click
        Assert.assertTrue(doubleClickPage.colorText.getAttribute("style").contains("red"));



    }

}
